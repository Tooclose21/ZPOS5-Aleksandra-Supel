package lista5;

public class Subject {
    private String name;
    private int hours;
    private int ects;

    public Subject(String name, int hours, int ects) {
        this.name = name;
        this.hours = hours;
        this. ects = ects;
    }

    @Override
    public String toString() {
        return String.format("Subject: %s, %d hours, %d ects", name, hours, ects);
    }
}
