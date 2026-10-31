package practice3;

import java.util.Arrays;
import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массивов N: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: N должно быть целым числом.");
            return;
        }
        int n = scanner.nextInt();

        int[] A = readArray(scanner, "A", n);
        int[] B = readArray(scanner, "B", n);

        int[] C = getMaxElements(A, B);

        System.out.println(Arrays.toString(C));
    }

    static int[] readArray(Scanner scanner, String name, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Введите " + (i + 1) + " число массива " + name + ": ");
                if (scanner.hasNextInt()) {
                    arr[i] = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Ошибка: нужно целое число. Повторите ввод.");
                    scanner.next();
                }
            }
        }
        return arr;
    }

    public static int[] getMaxElements(int[] A, int[] B) {
        int[] C = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            C[i] = Math.max(A[i], B[i]);
        }
        return C;
    }
}