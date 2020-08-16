import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2_1 {

    private static void replaceData(int[] dataInt) {
        dataInt[1] = 12;
        dataInt[2] = 2;
    }

    private static int calZeroPlace(int[] dataInt) {
        for (int i = 0; i < dataInt.length; i = i + 4) {
            if (dataInt[i] == 1) {
                dataInt[dataInt[i + 3]] = dataInt[dataInt[i + 1]] + dataInt[dataInt[i + 2]];
            } else if (dataInt[i] == 2) {
                dataInt[dataInt[i + 3]] = dataInt[dataInt[i + 1]] * dataInt[dataInt[i + 2]];
            } else if (dataInt[i] == 99) {
                return dataInt[0];
            }
        }
        return dataInt[0];
    }

    public static void main(String[] args) {
        int sum = 0;
        File file = new File(Day1_1.class.getClassLoader().getResource("day2.txt").getFile());
        try (Scanner sc = new Scanner(file)) {
            String[] data = sc.nextLine().split(",");
            int[] dataInt = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                dataInt[i] = Integer.valueOf(data[i]);
            }
            replaceData(dataInt);
            System.out.println(calZeroPlace(dataInt));
        } catch (FileNotFoundException fnfe) {
            System.out.println("file not found");
        }
    }
}
