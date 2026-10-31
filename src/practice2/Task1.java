package practice2;

import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число N: ");
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            //Валидация введённых данных
            if (n <= 0) {
                System.out.println("Ошибка: N должно быть натуральным числом (больше 0).");
            } else {
                double sum = 0.0;
                for (int i = 1; i <= n; i++) {
                    sum += 1.0 / Math.sqrt(i);
                }
                System.out.printf("Сумма ряда: %.6f%n", sum);
            }
        } else {
            System.out.println("Ошибка: введено не целое число.");
        }

        scanner.close();
    }
}