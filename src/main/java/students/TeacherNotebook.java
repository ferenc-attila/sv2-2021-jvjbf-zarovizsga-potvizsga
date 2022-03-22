package students;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TeacherNotebook {

    private List<Student> students = new ArrayList<>();

    public void readFromFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String row;
            while ((row = reader.readLine()) != null) {
                String[] cells = row.split(";");
                Student student = getStudent(cells);
                students.add(student);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file: " + path + "!");
        }
    }

    private Student getStudent(String[] cells) {
        Student student = new Student(cells[0], cells[1]);
        for (int i = 2; i < cells.length; i++) {
            student.addGrade(Integer.parseInt(cells[i]));
        }
        return student;
    }

    public List<String> findFailingStudents() {
        return students.stream()
                .filter(student -> student.getGrades().stream()
                        .mapToInt(Integer::intValue)
                        .average().orElse(0.0) < 2)
                .map(Student::getName)
                .toList();
    }

    public List<Student> getStudents() {
        return List.copyOf(students);
    }
}
