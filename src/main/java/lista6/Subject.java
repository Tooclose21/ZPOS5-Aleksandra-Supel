package lista6;

public class Subject {
    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public int getEcts() {
        return ects;
    }

    public Type getType() {
        return type;
    }

    public Ending getEnding() {
        return ending;
    }

    public enum Type {
        LECTURE,
        EXERCISES,
        LABORATORIES
    }

    public enum Ending{
        EXAM, CREDIT
    }

    private String name;
    private int hours;
    private int ects;
    private Type type;
    private Ending ending;

    public Subject(String name, int hours, int ects, Type type, Ending ending) {
        this.name = name;
        this.hours = hours;
        this. ects = ects;
        this.type = type;
        this.ending = ending;
    }

    @Override
    public String toString() {
        return String.format("Subject: %s, %d hours, %d ects", name, hours, ects);
    }
}
