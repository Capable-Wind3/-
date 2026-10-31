package practice2;

import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число N: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: N должно быть целым числом.");
            return;
        }
        int n = scanner.nextInt();
        System.out.println(isPrime(n));


        scanner.close();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}