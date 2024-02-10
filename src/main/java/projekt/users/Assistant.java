package projekt.users;

import projekt.NoPresenceHistory;
import projekt.Presence;

import java.util.LinkedList;
import java.util.List;

public class Assistant extends User {

    private List<Presence> presenceList;

    public Assistant(String name) {
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

    public void setPresenceList(List<Presence> presenceList) {
        this.presenceList = presenceList;
    }

    @Override
    public String csvRepresentation() {
        StringBuilder repr = new StringBuilder("assistant,").append(name);
        for (Presence presence : presenceList) {
            switch (presence) {
                case PRESENT -> repr.append(",1");
                case ABSENT -> repr.append(",0");
            }
        }
        return repr.toString();
    }
}
