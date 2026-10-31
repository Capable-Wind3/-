package practice3;

import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива N: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: N должно быть целым числом.");
            return;
        }
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите" + " " + (i + 1) + " число: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: число должно быть целым.");
                return;
            }
            arr[i] = scanner.nextInt();
        }

        int count = 0;
        boolean isIncreasing = false;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                if (!isIncreasing) {
                    count++;
                    isIncreasing = true;
                }
            } else {
                isIncreasing = false;
            }
        }

        System.out.println("Количество возрастающих участков: " + count);
    }
}