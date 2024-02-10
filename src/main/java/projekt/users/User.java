package projekt.users;

import projekt.Attendable;
import projekt.csvRepresentable;

public abstract class User implements Attendable, csvRepresentable {

    protected String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
