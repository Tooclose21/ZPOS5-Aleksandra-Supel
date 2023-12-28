package lista6;


import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Sentence sentence = new Sentence("BLa test\n and something!!!Bla.,to, test");
        System.out.printf("Words: %s\nChars: %s\n", sentence.getNumberOfWords(), sentence.getNumberOfCharacters());

        Subject subject = new Subject("Math", 4, 5, Subject.Type.LECTURE, Subject.Ending.EXAM);
        Subject subject2 = new Subject("Ultrasounds", 2, 1, Subject.Type.EXERCISES, Subject.Ending.CREDIT);
        SubjectStorage storage = new SubjectStorage(new HashMap<>() {{
            put("LM0198", subject);
            put("EU02983", subject2);
        }});
        for (Map.Entry<String, Subject> entry : storage.getAll()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.printf("Hours of lectures: %d\n", storage.hoursOf(Subject.Type.EXERCISES));
        System.out.printf("ECTS and hours of EXAM endings: %s", storage.hoursAndEctsOf(Subject.Ending.EXAM));
    }
}
