package practice3;

import java.util.Scanner;
import java.util.Arrays;
public class Task5 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
        scanner.close();
    }

    // ========== ГЛАВНОЕ МЕНЮ ==========
    static void menu() {
        boolean work = true;
        while (work) {
            printMenu();
            int choice = readInt("Выберите пункт: ");
            if (choice == 1) {
                calculate();
            } else if (choice == 2) {
                printAbout();
            } else if (choice == 3) {
                printDeveloper();
            } else if (choice == 0) {
                work = false;
            } else {
                System.out.println("Нет такого пункта, повторите ввод");
            }
        }
        System.out.println("Программа завершена");
    }

    // ========== СЦЕНАРИЙ РАСЧЁТА ==========
    static void calculate() {
        double[] params = new double[2];

        if (!readParams(params)) {
            return;
        }

        double energy = calculateEnergy(params);
        printResult(params, energy);
    }

    // ========== ВВОД (с сохранением в массив) ==========
    static boolean readParams(double[] params) {
        System.out.println("Введите параметры (0 - вернуться в меню):");

        double mass = readDouble("Масса тела m (кг, > 0): ");
        while (mass != 0 && !isCorrectMass(mass)) {
            System.out.println("Масса должна быть больше 0");
            mass = readDouble("Масса тела m (кг, > 0): ");
        }
        if (mass == 0) return false;
        params[0] = mass;

        double speed = readDouble("Скорость тела v (м/с, >= 0): ");
        while (speed != 0 && !isCorrectSpeed(speed)) {
            System.out.println("Скорость не может быть отрицательной");
            speed = readDouble("Скорость тела v (м/с, >= 0): ");
        }
        if (speed == 0) return false;
        params[1] = speed;

        return true;
    }

    // ========== ПРОВЕРКА ==========
    static boolean isCorrectMass(double mass) {
        return mass > 0;
    }

    static boolean isCorrectSpeed(double speed) {
        return speed >= 0;
    }

    // ========== ВЫЧИСЛЕНИЕ ==========
    static double calculateEnergy(double[] params) {
        double mass = params[0];
        double speed = params[1];
        return (mass * speed * speed) / 2.0;
    }

    // ========== ВЫВОД ==========
    static void printResult(double[] params, double energy) {
        System.out.println("Введённые параметры: " + Arrays.toString(params));
        System.out.printf("Масса: %.2f кг, Скорость: %.2f м/с\n", params[0], params[1]);
        System.out.printf("Кинетическая энергия: %.2f Дж\n", energy);
    }

    // ========== ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ ==========
    static void printMenu() {
        System.out.println("Главное меню:");
        System.out.println("1 - выполнить расчёт");
        System.out.println("2 - информация о программе");
        System.out.println("3 - информация о разработчике");
        System.out.println("0 - выход");
    }

    static void printAbout() {
        System.out.println("Программа рассчитывает кинетическую энергию тела.");
        System.out.println("Формула: Ek = (m * v^2) / 2");
    }

    static void printDeveloper() {
        System.out.println("Разработчик: Шевченко Александр Дмитриевич");
        System.out.println("Группа: РИ-250931");
    }

    // ========== БЕЗОПАСНОЕ ЧТЕНИЕ ЧИСЕЛ ==========
    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не целое число. Повторите ввод.");
            }
        }
    }

    static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не число. Повторите ввод.");
            }
        }
    }
}