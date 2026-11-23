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
        boolean running = true;

        while (running) {
            printMainMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> performCalculation();
                case "2" -> printProgramInfo();
                case "3" -> printDeveloperInfo();
                case "0" -> {
                    System.out.println("Выход из программы. До свидания!");
                    running = false;
                }
                default -> System.out.println("ОШИБКА: неверный пункт меню. Попробуйте снова.\n");
            }
        }

        System.out.println("Программа завершена");
    }

    // ========== СЦЕНАРИЙ РАСЧЁТА ==========
    static void performCalculation() {
        double[] params = new double[2];

        if (!readParams(params)) {
            System.out.println("Возврат в главное меню.\n");
            return;
        }

        double energy = calculateEnergy(params);
        printResult(params, energy);
    }

    // ========== ВВОД ПАРАМЕТРОВ ==========
    static boolean readParams(double[] params) {
        System.out.println("\nВведите параметры (q - вернуться в меню):");

        double mass = readDouble("Масса тела m (кг, > 0): ");

        if (Double.isNaN(mass)) {
            return false;
        }

        while (!isCorrectMass(mass)) {
            System.out.println("ОШИБКА: масса должна быть больше 0.");
            mass = readDouble("Масса тела m (кг, > 0): ");

            if (Double.isNaN(mass)) {
                return false;
            }
        }

        params[0] = mass;

        double speed = readDouble("Скорость тела v (м/с, >= 0): ");

        if (Double.isNaN(speed)) {
            return false;
        }

        while (!isCorrectSpeed(speed)) {
            System.out.println("ОШИБКА: скорость не может быть отрицательной.");
            speed = readDouble("Скорость тела v (м/с, >= 0): ");

            if (Double.isNaN(speed)) {
                return false;
            }
        }

        params[1] = speed;

        return true;
    }

    // ========== ВВОД ЧИСЛА С ПРОВЕРКОЙ ==========
    static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("q")) {
                return Double.NaN;
            }

            try {
                return Double.parseDouble(input.replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println(
                        "ОШИБКА: введено не число. Повторите ввод или введите q.\n"
                );
            }
        }
    }

    // ========== ПРОВЕРКА ПАРАМЕТРОВ ==========
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

    // ========== ВЫВОД РЕЗУЛЬТАТА ==========
    static void printResult(double[] params, double energy) {
        System.out.println("----------------------------------------------");

        System.out.println("Введённые параметры: " + Arrays.toString(params));
        System.out.printf("Масса: %.2f кг%n", params[0]);
        System.out.printf("Скорость: %.2f м/с%n", params[1]);

        System.out.println("Результаты расчёта:");
        System.out.printf("Кинетическая энергия: %.2f Дж%n", energy);

        System.out.println("----------------------------------------------");
    }

    // ========== ГЛАВНОЕ МЕНЮ ==========
    static void printMainMenu() {
        System.out.println("==============================================");
        System.out.println("               ГЛАВНОЕ МЕНЮ");
        System.out.println("==============================================");
        System.out.println("  1. Выполнить расчёт");
        System.out.println("  2. Информация о программе");
        System.out.println("  3. Информация о разработчике");
        System.out.println("  0. Выход");
        System.out.println("==============================================");
        System.out.print("Выберите пункт меню: ");
    }

    // ========== ИНФОРМАЦИЯ О ПРОГРАММЕ ==========
    static void printProgramInfo() {
        System.out.println();
        System.out.println("--- Информация о программе ---");
        System.out.println("Название: Расчёт кинетической энергии тела");
        System.out.println("Формула: Ek = (m * v^2) / 2");
        System.out.println("Область: Физика");
        System.out.println("Описание: Программа вычисляет кинетическую");
        System.out.println("энергию по массе и скорости тела.");
    }

    // ========== ИНФОРМАЦИЯ О РАЗРАБОТЧИКЕ ==========
    static void printDeveloperInfo() {
        System.out.println();
        System.out.println("--- Информация о разработчике ---");
        System.out.println("Студент: Шевченко Александр Дмитриевич");
        System.out.println("Группа: РИ-250931");
    }
}