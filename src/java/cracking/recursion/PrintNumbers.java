package cracking.recursion;

import java.util.Scanner;

public class PrintNumbers {

    private static int number = 0;
    private static int it = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        PrintNumbers.printNumbers();
    }

    private static void printNumbers() {
        while (it <= number) {
            System.out.printf("%d", it++);
        }
    }
}
