package projekt.io;

import list7.ComplexNumber;
import projekt.Presence;
import projekt.users.Assistant;
import projekt.users.Student;
import projekt.users.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class IoProcessor {

    public static List<User> readPresence(String path) {
        File file = new File(path);

        if (!file.exists()) {
            return new LinkedList<>();
        }
        System.out.println("Check");
        List<User> users = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equals("student")) {
                    Student student = new Student(values[1]);
                    student.setPresenceList(Arrays.stream(values).skip(2).map(it -> it.equals("1") ? Presence.PRESENT : Presence.ABSENT).collect(Collectors.toList()));
                    users.add(student);
                } else if (values[0].equals("assistant")) {
                    Assistant assistant = new Assistant(values[1]);
                    assistant.setPresenceList(Arrays.stream(values).skip(2).map(it -> it.equals("1") ? Presence.PRESENT : Presence.ABSENT).collect(Collectors.toList()));
                    users.add(assistant);
                } else {
                    throw new IllegalStateException("No such type: " + values[0]);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public static void writePresence(String path, List<User> users) {
        File outputFile = new File(path);

        if (!outputFile.exists()) {
            try {
                Files.createFile(Paths.get(path));
            } catch (IOException e) {
                throw new RuntimeException("Could not create file" + e.getMessage());
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (User user : users) {
                writer.write(user.csvRepresentation());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not write to file: " + e.getMessage());
        }
    }


}
