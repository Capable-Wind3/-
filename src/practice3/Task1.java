package practice3;

import java.util.Scanner;
import java.util.Arrays;
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество сортируемых чисел N: ");
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
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i += 2) {
            System.out.print(arr[i] + " ");
        }

        for (int i = 1; i < arr.length; i += 2) {
            System.out.print(arr[i] + " ");
        }
    }
}