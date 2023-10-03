package vn.edu.usth.imdbclient.adapter;
import java.io.Serializable;
public class Feat implements Serializable {
    private final String name; // name of the employee
    private final String email; // email of the employee

    public Feat(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
