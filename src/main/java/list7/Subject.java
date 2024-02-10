package list7;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Subject {
    private String name;
    private int hours;
    private int ects;

    public Subject(String name, int hours, int ects) {
        this.name = name;
        this.hours = hours;
        this.ects = ects;
    }

    public static Subject fromJson(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException();
        }
        return fromJsonParse(file);
    }

    private static Subject fromJsonParse(File file) {
        Subject subject;
        try (FileReader reader = new FileReader(file)) {
            JSONTokener jsonTokener = new JSONTokener(reader);
            JSONObject subjectObject = new JSONObject(jsonTokener);

            String name = subjectObject.getString("name");
            int hoursPerWeek = subjectObject.getInt("hours");
            int ectsAmount = subjectObject.getInt("ects");
            subject = new Subject(name, hoursPerWeek, ectsAmount);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return subject;
    }

    public void toJson(String outputPath) {
        File outputFile = new File(outputPath);

        if (!outputFile.exists()) {
            try {
                Files.createFile(Paths.get(outputPath));
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
        toJsonParse(outputFile);
    }

        private void toJsonParse(File outputFile) {
        JSONObject subjectJson = new JSONObject();
        subjectJson.put("name", name);
        subjectJson.put("hours", hours);
        subjectJson.put("ects", ects);

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(subjectJson.toString(4));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return String.format("Subject: %s, %d hours, %d ects", name, hours, ects);
    }
}
