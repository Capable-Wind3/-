package practice3;

import java.util.Scanner;
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = readInt(scanner, "Введите M (количество строк): ");
        int N = readInt(scanner,"Введите N (количество столбцов): ");
        double D = readDouble(scanner,"Введите D (шаг/прибавление): ");

        double[] initialSet = new double[M];
        System.out.println("Введите " + M + " чисел:");
        for (int i = 0; i < M; i++) {
            initialSet[i] = readDouble(scanner,(i + 1) + "число: ");
        }

        double[][] matrix = new double[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = initialSet[i] + j * D;
            }
        }

        System.out.println("Полученная матрица:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%8.2f ", matrix[i][j]);
            }
            System.out.println();
        }
        scanner.close();
    }

    static int readInt(Scanner scanner, String name) {
        System.out.print(name);
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: число должно быть целым.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    static double readDouble(Scanner scanner, String name) {
        System.out.print(name);
        if (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: число должно быть вещественным.");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}