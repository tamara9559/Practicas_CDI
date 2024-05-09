package Model;

import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

@SessionScoped
public class Student implements Serializable {
    private int id;
    private String name;
    private String email;
    private int semester;

    public Student() {
    }

    public Student(int id, String name, String email, int semester) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
