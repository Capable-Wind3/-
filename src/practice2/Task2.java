package practice2;

import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите вещественное число X: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: X должно быть числом.");
            return;
        }
        double x = scanner.nextDouble();

        System.out.print("Введите целое число N (> 0): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: N должно быть целым числом.");
            return;
        }
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Ошибка: N должно быть больше 0.");
            return;
        }

        double sum = 1.0;
        double currentTerm = x;

        for (int i = 1; i <= n; i++) {
            sum += currentTerm;
            currentTerm = currentTerm * x / (i + 1);
        }

        System.out.printf("Значение выражения: %.6f%n", sum);
        System.out.printf("Значение Math.exp(X): %.6f%n", Math.exp(x));

        scanner.close();
    }
}