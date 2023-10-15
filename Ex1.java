import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex1 {
    /**
     * Program liczy zasięg i maksymalną wysokość rzutu ukośnego
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj prędkość: ");
        double v0;
        try {
            v0 = scanner.nextDouble();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Prędkość musi być liczbą rzeczywistą");
        }
        System.out.println("Podaj kąt uderzenia: ");
        double angle;
        try {
            angle = scanner.nextDouble();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Kąt uderzenia musi być liczbą");
        }
        double angle_radian = Math.toRadians(angle);

        scanner.close();

        if (v0 < 0 || angle < 0 || angle > 90) {
            System.out.println("Nieprawidłowe dane wejściowe.");
        } else {
            double distance = (Math.pow(v0, 2) * Math.sin(2 * angle_radian)) / 9.81;
            double maxHeight = (Math.pow(v0, 2) * Math.sin(angle_radian) * Math.sin(angle_radian) / (2 * 9.81));

            System.out.println("Zasięg: " + distance + " m");
            System.out.println("Maksymalna wysokość: " + maxHeight + " m");
        }
    }
}
