package lista1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex4 {
    /**
     * Program wyświetla tabliczke mnożena do n, gdzie n jest liczba podana przez uzytkownika
     * @param args command line args
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.print("Podaj liczbę całkowitą z przedziału [1,9]: ");
        try {
            n = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Nie podano liczby calkowitej.");
        }

        scanner.close();

        if ((n > 9) || (n < 1)) {
            System.out.print("Podano liczbę spoza dopuszczalnego przedziału.");
        } else {
            int[][] tabA = new int[n+1][n+1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    tabA[i][j] = i * j;
                    System.out.print(tabA[i][j] + "\t");
                }
                System.out.println();
            }

        }
    }
}



