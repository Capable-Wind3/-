package practice2;

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
        Task4 myTriangle = new Task4();
        myTriangle.printCalculations(n);
    }
    // Метод для вывода результатов вычислений
    public void printCalculations(double side) {
        double p = 3 * side;
        double s = (side * side * Math.sqrt(3)) / 4;

        System.out.println("Для треугольника со стороной " + side + ":");
        System.out.println("Периметр = " + p);
        System.out.println("Площадь = " + s);
    }
}