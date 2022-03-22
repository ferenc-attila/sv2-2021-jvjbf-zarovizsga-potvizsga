package students;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String className;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name, String className) {
        this.name = name;
        this.className = className;
    }

    public void addGrade(int grade) {
        validateGrade(grade);
        grades.add(grade);
    }

    private void validateGrade(int grade) {
        if (grade < 1 || grade > 5) {
            throw new IllegalArgumentException("Invalid grade: " + grade + "! It must be between 1 and 5!");
        }
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public List<Integer> getGrades() {
        return List.copyOf(grades);
    }
}
