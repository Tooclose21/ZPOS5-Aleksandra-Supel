package lista1;

import java.util.Scanner;

public class Ex3 {
    /**
     * Program zmienia kolor zapisany w systemie HEX na kolor zapisany w systemie RGB
     * @param args command line args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj kod HEX: ");
        String k = scanner.nextLine();
        if (k.length() != 6) {
            throw new IllegalArgumentException("HEX musi mieć 6 znaków");
        }
        if (!hexCode(k)) {
            throw new IllegalArgumentException("HEX może zawierać tylko litery i cyfry");
        }
        scanner.close();
        String s1 = k.substring(0, 2);
        String s2 = k.substring(2, 4);
        String s3 = k.substring(4, 6);

        int r = Integer.parseInt(s1, 16);
        int g = Integer.parseInt(s2, 16);
        int b = Integer.parseInt(s3, 16);
        System.out.printf("(" + r + "," + g + "," + b + ")");

    }
    private static boolean hexCode (String hex) {
        String reference = "0123456789abcdefABCDEF";
        for (int i = 0; i < hex.length(); i++) {
            int id = reference.indexOf(hex.charAt(i));
            if (id == -1) {
                return false;
            }
        }
        return true;
    }
}
