import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1_2 {
    public static int calculateFuel (int mass) {
        int res = 0;
        while (mass > 0) {
            mass = mass / 3 - 2;
            if (mass > 0) res = res + mass;
        }
        return res;
    }

    public static void main(String[] args) {
        int sum = 0;
        File file = new File(Day1_1.class.getClassLoader().getResource("day1.txt").getFile());
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                int mass = sc.nextInt();
                int fuel = calculateFuel(mass);
                sum = sum + fuel;
                System.out.printf("mass: %6d, fuel: %6d\n", mass, fuel);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("file not found");
        }
        System.out.println("sum: " + sum);
    }
}
