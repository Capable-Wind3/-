package src.practice2;

import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число N > 1: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: N должно быть целым числом.");
            return;
        }

        int n = scanner.nextInt();

        if (n <= 1) {
            System.out.print("Ошибка: N должно быть больше 1.");
            return;
        }

        System.out.println(isPrime(n));

        scanner.close();
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}