package src.practice2;

import java.util.Scanner;
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину стороны треугольника (> 0): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введенное значение должно быть целым числом.");
            return;
        }
        int n = scanner.nextInt();

        if (n <= 0){
            System.out.print("Ошибка: введённое значение должно быть больше чем 0");
            return;
        }

        printCalculations(n);
    }

    public static void printCalculations(double side) {
        double p = 3 * side;
        double s = (Math.pow(side, 2) * Math.sqrt(3)) / 4;

        System.out.println("Для треугольника со стороной " + side + ":");
        System.out.println("Периметр = " + p);
        System.out.println("Площадь = " + s);
    }
}