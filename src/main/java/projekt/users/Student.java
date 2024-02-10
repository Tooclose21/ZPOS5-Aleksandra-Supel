package projekt.users;

import projekt.NoPresenceHistory;
import projekt.Presence;

import java.util.LinkedList;
import java.util.List;

public class Student extends User {

    private List<Presence> presenceList;

    public Student(String name) {
        super(name);
        presenceList = new LinkedList<>();
    }

    @Override
    public void setPresence(Presence presence) {
        presenceList.add(presence);
    }

    @Override
    public void editPresence(Presence presence) {
        if (presenceList.isEmpty()) {
            throw new NoPresenceHistory("No presence to alter!");
        }
        presenceList.remove(presenceList.size() - 1);
        presenceList.add(presence);
    }

    public void setPresenceList(List<Presence> presences) {
        this.presenceList = presences;
    }

    @Override
    public String csvRepresentation() {
        StringBuilder repr = new StringBuilder("student,").append(name);
        for (Presence presence : presenceList) {
            switch (presence) {
                case PRESENT -> repr.append(",1");
                case ABSENT -> repr.append(",0");
            }
        }
        return repr.toString();
    }
}
