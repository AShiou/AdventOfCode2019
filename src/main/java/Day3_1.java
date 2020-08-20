import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day3_1 {

    private static Set<Point> runFirstPath(String[] firstPath) {
        Set<Point> pointSet = new HashSet<>();
        int x = 0;
        int y = 0;
        for (int i = 0; i < firstPath.length; i++) {
            char dir = firstPath[i].charAt(0);
            int val = Integer.valueOf(firstPath[i].substring(1));
            switch (dir) {
                case 'R':
                    for (int j = 0; j < val; j++) {
                        x = x + 1;
                        Point p = new Point(x, y);
                        pointSet.add(p);
                    }
                    break;
                case 'L':
                    for (int j = 0; j < val; j++) {
                        x = x - 1;
                        Point p = new Point(x, y);
                        pointSet.add(p);
                    }
                    break;
                case 'U':
                    for (int j = 0; j < val; j++) {
                        y = y + 1;
                        Point p = new Point(x, y);
                        pointSet.add(p);
                    }
                    break;
                case 'D':
                    for (int j = 0; j < val; j++) {
                        y = y - 1;
                        Point p = new Point(x, y);
                        pointSet.add(p);
                    }
                    break;
            }
        }
        return pointSet;
    }

    private static int runSecondPath(String[] secondPath, Set<Point> pointSet) {
        int res = Integer.MAX_VALUE;
        int x = 0;
        int y = 0;
        for (int i = 0; i < secondPath.length; i++) {
            char dir = secondPath[i].charAt(0);
            int val = Integer.valueOf(secondPath[i].substring(1));
            switch (dir) {
                case 'R':
                    for (int j = 0; j < val; j++) {
                        x = x + 1;
                        Point p = new Point(x, y);
                        if (pointSet.contains(p) && Math.abs(x) + Math.abs(y) < res) {
                            res = Math.abs(x) + Math.abs(y);
                        }
                    }
                    break;
                case 'L':
                    for (int j = 0; j < val; j++) {
                        x = x - 1;
                        Point p = new Point(x, y);
                        if (pointSet.contains(p) && Math.abs(x) + Math.abs(y) < res) {
                            res = Math.abs(x) + Math.abs(y);
                        }
                    }
                    break;
                case 'U':
                    for (int j = 0; j < val; j++) {
                        y = y + 1;
                        Point p = new Point(x, y);
                        if (pointSet.contains(p) && Math.abs(x) + Math.abs(y) < res) {
                            res = Math.abs(x) + Math.abs(y);
                        }
                    }
                    break;
                case 'D':
                    for (int j = 0; j < val; j++) {
                        y = y - 1;
                        Point p = new Point(x, y);
                        if (pointSet.contains(p) && Math.abs(x) + Math.abs(y) < res) {
                            res = Math.abs(x) + Math.abs(y);
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
            Set<Point> pointSet = runFirstPath(firstPath);
            System.out.println(runSecondPath(secondPath, pointSet));
        }
    }
}
