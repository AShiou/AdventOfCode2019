import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3_2 {
  private static Map<Point, Integer> runFirstPath(String[] firstPath) {
    Map<Point, Integer> pointMap = new HashMap<>();
    int x = 0;
    int y = 0;
    int step = 0;
    for (int i = 0; i < firstPath.length; i++) {
      char dir = firstPath[i].charAt(0);
      int val = Integer.valueOf(firstPath[i].substring(1));
      switch (dir) {
        case 'R':
          for (int j = 0; j < val; j++) {
            x = x + 1;
            step++;
            Point p = new Point(x, y);
            pointMap.put(p, step);
          }
          break;
        case 'L':
          for (int j = 0; j < val; j++) {
            x = x - 1;
            step++;
            Point p = new Point(x, y);
            pointMap.put(p, step);
          }
          break;
        case 'U':
          for (int j = 0; j < val; j++) {
            y = y + 1;
            step++;
            Point p = new Point(x, y);
            pointMap.put(p, step);
          }
          break;
        case 'D':
          for (int j = 0; j < val; j++) {
            y = y - 1;
            step++;
            Point p = new Point(x, y);
            pointMap.put(p, step);
          }
          break;
      }
    }
    return pointMap;
  }

  private static int runSecondPath(String[] secondPath, Map<Point, Integer> pointMap) {
    int res = Integer.MAX_VALUE;
    int x = 0;
    int y = 0;
    int step = 0;
    for (int i = 0; i < secondPath.length; i++) {
      char dir = secondPath[i].charAt(0);
      int val = Integer.valueOf(secondPath[i].substring(1));
      switch (dir) {
        case 'R':
          for (int j = 0; j < val; j++) {
            x = x + 1;
            step++;
            Point p = new Point(x, y);
            if (pointMap.containsKey(p)) {
              int tempStepSum = step + pointMap.get(p);
              if (tempStepSum < res) {
                res = tempStepSum;
              }
            }
          }
          break;
        case 'L':
          for (int j = 0; j < val; j++) {
            x = x - 1;
            step++;
            Point p = new Point(x, y);
            if (pointMap.containsKey(p)) {
              int tempStepSum = step + pointMap.get(p);
              if (tempStepSum < res) {
                res = tempStepSum;
              }
            }
          }
          break;
        case 'U':
          for (int j = 0; j < val; j++) {
            y = y + 1;
            step++;
            Point p = new Point(x, y);
            if (pointMap.containsKey(p)) {
              int tempStepSum = step + pointMap.get(p);
              if (tempStepSum < res) {
                res = tempStepSum;
              }
            }
          }
          break;
        case 'D':
          for (int j = 0; j < val; j++) {
            y = y - 1;
            step++;
            Point p = new Point(x, y);
            if (pointMap.containsKey(p)) {
              int tempStepSum = step + pointMap.get(p);
              if (tempStepSum < res) {
                res = tempStepSum;
              }
            }
          }
          break;
      }
    }
    return res;
  }

  public static void main(String[] args) throws FileNotFoundException {
    int sum = 0;
    File file = new File(Day1_1.class.getClassLoader().getResource("day3.txt").getFile());
    try (Scanner sc = new Scanner(file)) {
      String[] firstPath = sc.nextLine().split(",");
      String[] secondPath = sc.nextLine().split(",");
      Map<Point, Integer> pointSet = runFirstPath(firstPath);
      System.out.println(runSecondPath(secondPath, pointSet));
    }
  }
}