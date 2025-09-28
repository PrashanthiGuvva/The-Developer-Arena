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

    public int getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }

    public void setName(String name) { this.name = name; }
    public void setMarks(double marks) { this.marks = marks; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentManagementSystem {

    private static ArrayList<Student> studentList = new ArrayList<>();
    private static HashMap<Integer, Student> studentMap = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        if (studentMap.containsKey(id)) {
            System.out.println("⚠️ Student with this ID already exists.");
            return;
        }
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Student Marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(id, name, marks);
        studentList.add(s);
        studentMap.put(id, s);
        System.out.println("✅ Student added successfully!");
    }

    public static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("⚠️ No students found.");
            return;
        }
        System.out.println("\n📒 Student Records:");
        studentList.forEach(System.out::println);
    }

    public static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (!studentMap.containsKey(id)) {
            System.out.println("⚠️ Student not found.");
            return;
        }
        Student s = studentMap.get(id);
        System.out.print("Enter new name: ");
        String newName = sc.nextLine();
        System.out.print("Enter new marks: ");
        double newMarks = sc.nextDouble();

        s.setName(newName);
        s.setMarks(newMarks);
        System.out.println("✅ Student updated successfully!");
    }

    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        if (!studentMap.containsKey(id)) {
            System.out.println("⚠️ Student not found.");
            return;
        }
        Student s = studentMap.remove(id);
        studentList.remove(s);
        System.out.println("🗑️ Student deleted successfully!");
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("👋 Exiting. Goodbye!");
                default -> System.out.println("⚠️ Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}

