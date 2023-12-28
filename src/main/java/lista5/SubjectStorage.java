package lista5;

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

    public Optional<Subject> getSubject(String code) {
        return Optional.ofNullable(subjects.get(code));
    }

    public Set<Map.Entry<String, Subject>> getAll() {
        return subjects.entrySet();
    }
}
