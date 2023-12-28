package lista6;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class SubjectStorage {
    private Map<String, Subject> subjects;

    public SubjectStorage(Map<String, Subject> subjects) {
        this.subjects = subjects;
    }

    public boolean add(String code, Subject subject) {
        if (subjects.containsKey(code)) {
            return false;
        }
        subjects.put(code, subject);
        return true;
    }

    public boolean remove(String code) {
        if (!subjects.containsKey(code)) {
            return false;
        }
        subjects.remove(code);
        return true;
    }

    public boolean replace(String code, Subject subject) {
        if (!subjects.containsKey(code)) {
            return false;
        }
        subjects.put(code, subject);
        return true;
    }

    public int hoursOf(Subject.Type type) {
        return subjects.values().stream()
                .filter(subject -> subject.getType() == type)
                .mapToInt(Subject::getHours)
                .sum();
    }

    public Map<String, Integer> hoursAndEctsOf(Subject.Ending ending) {
        Map<String, Integer> result = new HashMap<>();
        result.put("ECTS sum", subjects.values().stream()
                .filter(subject -> subject.getEnding() == ending)
                .mapToInt(Subject::getEcts).sum());
        result.put("Hours sum", subjects.values().stream()
                .filter(subject -> subject.getEnding() == ending)
                .mapToInt(Subject::getHours).sum());
        return result;
    }

    public Optional<Subject> getSubject(String code) {
        return Optional.ofNullable(subjects.get(code));
    }

    public Set<Map.Entry<String, Subject>> getAll() {
        return subjects.entrySet();
    }
}
