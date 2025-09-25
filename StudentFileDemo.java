import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + marks;
    }

    public static Student fromString(String line) {
        String[] parts = line.split(",");
        return new Student(
                Integer.parseInt(parts[0]),
                parts[1],
                Double.parseDouble(parts[2])
        );
    }
}

public class StudentFileDemo {
    private static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Prashanthi", 88.5));
        students.add(new Student(2, "Rahul", 76.0));
        students.add(new Student(3, "Anjali", 92.3));
        saveStudents(students);
        List<Student> loadedStudents = loadStudents();
        System.out.println("Loaded Students from File:");
        for (Student s : loadedStudents) {
            System.out.println(s);
        }
    }
    private static void saveStudents(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.write(s.toString());
                writer.newLine();
            }
            System.out.println("Students saved to file.");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
    private static List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                students.add(Student.fromString(line));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found. Run save first.");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return students;
    }
}

