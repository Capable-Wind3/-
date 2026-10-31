package practice2;

import java.util.Scanner;
public class Task5 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMainMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    performCalculation();
                    break;
                case "2":
                    printProgramInfo();
                    break;
                case "3":
                    printDeveloperInfo();
                    break;
                case "0":
                    System.out.println("Выход из программы. До свидания!");
                    running = false;
                    break;
                default:
                    System.out.println("ОШИБКА: неверный пункт меню. Попробуйте снова.\n");
            }
        }

        scanner.close();
    }

    // ========== ГЛАВНОЕ МЕНЮ ==========
    private static void printMainMenu() {
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

    // ========== ВЫПОЛНЕНИЕ РАСЧЁТА ==========
    private static void performCalculation() {
        System.out.println();
        System.out.println("--- Расчёт кинетической энергии ---");
        System.out.println("(для выхода в главное меню введите 'q')");

        double mass = readDoubleWithValidation("Введите массу тела m (кг > 0): ", true);
        if (Double.isNaN(mass)) {
            System.out.println("Возврат в главное меню.\n");
            return;
        }

        double speed = readDoubleWithValidation("Введите скорость тела v (м/с >= 0): ", false);
        if (Double.isNaN(speed)) {
            System.out.println("Возврат в главное меню.\n");
            return;
        }

        double kineticEnergy = calculateKineticEnergy(mass, speed);

        printResult(mass, speed, kineticEnergy);
    }

    // ========== ИНФОРМАЦИЯ О ПРОГРАММЕ ==========
    private static void printProgramInfo() {
        System.out.println();
        System.out.println("--- Информация о программе ---");
        System.out.println("Название: Расчёт кинетической энергии тела");
        System.out.println("Формула:  Ek = (m * v^2) / 2");
        System.out.println("Область:  Физика");
        System.out.println("Описание: Программа вычисляет кинетическую");
        System.out.println("          энергию по массе и скорости тела.");
    }

    // ========== ИНФОРМАЦИЯ О РАЗРАБОТЧИКЕ ==========
    private static void printDeveloperInfo() {
        System.out.println();
        System.out.println("--- Информация о разработчике ---");
        System.out.println("Студент:  Шевченко Александр Дмитриевич");
        System.out.println("Группа:   РИ-250931");
    }

    private static double readDoubleWithValidation(String prompt, boolean mustBePositive) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("q")) {
                return Double.NaN;
            }

            double value;
            try {
                value = Double.parseDouble(input.replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("ОШИБКА: введено не число. Повторите ввод или введите 'q' для выхода.\n");
                continue;
            }

            if (mustBePositive && value <= 0) {
                System.out.println("ОШИБКА: значение должно быть строго больше нуля. Повторите ввод или введите 'q'.\n");
                continue;
            }

            if (!mustBePositive && value < 0) {
                System.out.println("ОШИБКА: значение не может быть отрицательным. Повторите ввод или введите 'q'.\n");
                continue;
            }

            return value;
        }
    }

    // ========== РАСЧЁТ ФОРМУЛЫ ==========
    private static double calculateKineticEnergy(double mass, double speed) {
        return (mass * speed * speed) / 2.0;
    }

    // ========== ВЫВОД РЕЗУЛЬТАТА ==========
    private static void printResult(double mass, double speed, double kineticEnergy) {
        System.out.println("----------------------------------------------");
        System.out.println("  Результаты расчёта:");
        System.out.printf("  Масса тела:           m = %.2f кг%n", mass);
        System.out.printf("  Скорость тела:        v = %.2f м/с%n", speed);
        System.out.printf("  Кинетическая энергия: Ek = %.2f Дж%n", kineticEnergy);
        System.out.println("----------------------------------------------");
    }
}