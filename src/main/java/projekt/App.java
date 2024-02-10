package projekt;

import projekt.io.IoProcessor;
import projekt.users.Assistant;
import projekt.users.Student;
import projekt.users.User;

import java.net.ProxySelector;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        List<User> users = IoProcessor.readPresence("src/main/resources/presence.csv");

        boolean running = true;
        do {
            System.out.println("Enter:\np -> for checking presence,\na -> for appending assistant,\ns -> for appending student,\nwho -> for printing users,\nq -> for quit");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "a" -> {
                    System.out.println("Enter name");
                    String name = scanner.nextLine();
                    users.add(new Assistant(name));
                }
                case "s" -> {
                    System.out.println("Enter name");
                    String name = scanner.nextLine();
                    users.add(new Student(name));
                }
                case "p" -> users.forEach(it -> {
                    while (!getPresence(it, scanner)) {
                    }
                });
                case "q" -> running = false;
                case "who" -> users.forEach(it -> System.out.println(it.getName()));
            }
        } while (running);
        IoProcessor.writePresence("src/main/resources/presence.csv", users);
        System.out.println("Have a good day :)");


    }

    private static boolean getPresence(User user, Scanner scanner) {
        System.out.println("Presence for: " + user.getName());
        System.out.println("Enter 0 for absent, 1 for present");

        int presence;
        try {
            presence = scanner.nextInt();
        } catch (RuntimeException e) {
            throw new InputMismatchException("Invalid input only 1 or 0 is accepted!");
        }

        if (presence != 0 && presence != 1) {
            System.out.println("Invalid input, try again");
            return false;
        }

        user.setPresence(presence == 1 ? Presence.PRESENT : Presence.ABSENT);
        return true;
    }
}
