package src.practice1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите три числа: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int positive = 0;
        int negative = 0;

        int[] numbers = {a, b, c};

        if (numbers[0] > 0) {
            positive++;
        } else if (numbers[0] <0 ){
            negative++;
        }

        if (numbers[1] > 0) {
            positive++;
        } else if (numbers[1] <0){
            negative++;
        }

        if (numbers[2] > 0) {
            positive++;
        } else if (numbers[2] <0){
            negative++;
        }

        System.out.print("Положительных: " + positive + ", отрицательных: " + negative + ": ");
    }
}