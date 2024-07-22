package project;

public class StudentInput {
    private int id;
    private String name;
    private String email;

    public StudentInput(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "[Student id: "+ id + ", Student name: "+ name + ", Student email: " + email + "]";
    }
}
