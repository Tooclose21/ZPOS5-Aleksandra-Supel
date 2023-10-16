import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex6 {
    /**
     * Program wyswietla date podana przez uzytkownika w formacie DD-MM-YYYY.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dzien;
        int miesiac;
        int rok;

        System.out.println("Podaj dzień, miesiąc oraz rok: ");
        try {
            dzien = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Dzien powinien byc liczba");
        }
        try {
            miesiac = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Miesiac powinien byc liczba");
        }
        try {
            rok = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Rok powinien byc liczba");
        }

        try {
            String data2 = data(dzien, miesiac, rok);
            System.out.println(data2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Funkcja zwraca date w formacie DD-MM-YYYY.
     * @param dzien dzien miesaca.
     * @param miesiac miesiac roku.
     * @param rok rok.
     * @return Data w formacie DD-MM-YYYY.
     * @throws IllegalArgumentException kiedy podany dzien jest niepoprawny.
     */
    public static String data(int dzien, int miesiac, int rok) {
        int dopuszczalnyDzien = 31;

        if (miesiac < 1 || miesiac > 12) {
            throw new IllegalArgumentException("Podano nieprawidlowy miesiac");
        }

        if (miesiac == 4 || miesiac == 6 || miesiac == 9 || miesiac == 11) {
            dopuszczalnyDzien = 30;
        }

        if (miesiac == 2 && rok % 4 == 0) {
            dopuszczalnyDzien = 29;
        } else if (miesiac == 2){
            dopuszczalnyDzien = 28;
        }

        if ((dzien < 1) || (dzien > dopuszczalnyDzien)) {
            throw new IllegalArgumentException("Podano nieprawidłowy dzień.");
        }

        String nowyDzien = String.format("%02d", dzien);
        String nowyMiesiac = String.format("%02d", miesiac);
        return nowyDzien + "-" + nowyMiesiac + "-" + rok;
    }
}
