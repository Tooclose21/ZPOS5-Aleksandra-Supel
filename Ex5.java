import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex5 {
    /**
     * Program liczy rownanie prostej przechodzacej przez dwa punkty, podane przez urzytownika.
     * @param args command line args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pierwszyPunktX;
        double pierwszyPunktY;
        double drugiPunktX;
        double drugiPunktY;
        System.out.println("Podaj współrzędne pierwszego punktu: ");
        try {
            pierwszyPunktX =scanner.nextDouble();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Wspolrzedna powinna byc liczba");
        }
        try {
            pierwszyPunktY =scanner.nextDouble();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Wspolrzedna powinna byc liczba");
        }
        System.out.println("Podaj współrzędne drugiego punktu: ");
        try {
            drugiPunktX =scanner.nextDouble();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Wspolrzedna powinna byc liczba");
        }
        try {
            drugiPunktY =scanner.nextDouble();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Wspolrzedna powinna byc liczba");
        }

        scanner.close();

        try {
            double[] rowananie = wspolczynniki(pierwszyPunktX, pierwszyPunktY, drugiPunktX, drugiPunktY);
            System.out.println("y = " + rowananie[0] + "x + " + rowananie[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Funkcja zwraca wspolczynniki rownania prostej przechodzacej przez dwa punkty.
     * @param pierwszyPunktX pierwsza wspolrzedna pierwszego punktu.
     * @param pierwszyPunktY druga wspolrzedna pierwszego punktu.
     * @param drugiPunktX pierwsza wspolrzedna drugiego punktu.
     * @param drugiPunktY druga wspolrzedna drugiego punktu.
     * @return liste [a, b] gdzie a i b to wspolczynniki rownania prostej w postaci t = ax + b.
     * @throws IllegalArgumentException kiedy oba punkty sa takie same.
     */
    public static double[] wspolczynniki(double pierwszyPunktX, double pierwszyPunktY, double drugiPunktX, double drugiPunktY) {
        if ((drugiPunktX == pierwszyPunktX) && (drugiPunktY == pierwszyPunktY)){
            throw new IllegalArgumentException("Współrzędne punktów nie mogą być takie same.");
        }
        double a = (drugiPunktY - pierwszyPunktY) / (drugiPunktX - pierwszyPunktX);
        double b = pierwszyPunktY - (a * pierwszyPunktX);
        return new double[]{a, b};
    }
}
