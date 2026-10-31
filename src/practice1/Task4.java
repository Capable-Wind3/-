package practice1;

import java.util.Scanner;
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Приглашение — описание программы
        System.out.println("==============================================");
        System.out.println("  Программа расчёта кинетической энергии тела");
        System.out.println("  Формула: Ek = (m * v^2) / 2");
        System.out.println("==============================================");

        //Приглашение для ввода данных
        System.out.print("Введите массу тела m (кг): ");
        if (!scanner.hasNextDouble()) {
            System.out.println("ОШИБКА: введено не число.");
            scanner.close();
            return;
        }
        double m = scanner.nextDouble();

        System.out.print("Введите скорость тела v (м/с): ");
        if (!scanner.hasNextDouble()) {
            System.out.println("ОШИБКА: введено не число.");
            scanner.close();
            return;
        }
        double v = scanner.nextDouble();

        //Валидация введённых данных
        if (m <= 0) {
            System.out.println("ОШИБКА: масса должна быть положительным числом (m > 0).");
            System.out.println("Программа завершена.");
            scanner.close();
            return; // прекращаем выполнение
        }

        if (v < 0) {
            System.out.println("ОШИБКА: скорость не может быть отрицательной (v >= 0).");
            System.out.println("Программа завершена.");
            scanner.close();
            return; // прекращаем выполнение
        }

        //Выполнение расчёта по формуле
        double kineticEnergy = (m * v * v) / 2.0;

        //Вывод результатов на консоль
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println("  Результаты расчёта:");
        System.out.printf("  Масса тела:          m = %.2f кг%n", m);
        System.out.printf("  Скорость тела:       v = %.2f м/с%n", v);
        System.out.printf("  Кинетическая энергия: Ek = %.2f Дж%n", kineticEnergy);
        System.out.println("----------------------------------------------");

        scanner.close();
    }
}
