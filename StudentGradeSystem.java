import java.util.Scanner;

public class StudentGradeSystem {
    public static char calculateGrade(int avg) {
        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 60) return 'C';
        else if (avg >= 40) return 'D';
        else return 'F';
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int students = scanner.nextInt();
        System.out.print("Enter number of subjects: ");
        int subjects = scanner.nextInt();
        // 2D array to store marks [students][subjects]
        int[][] marks = new int[students][subjects];
        int[] total = new int[students];
        char[] grades = new char[students];
        for (int i = 0; i < students; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ": ");
            for (int j = 0; j < subjects; j++) {
                System.out.print("Subject " + (j + 1) + ": ");
                marks[i][j] = scanner.nextInt();
                total[i] += marks[i][j];
            }

            int avg = total[i] / subjects;
            grades[i] = calculateGrade(avg);
        }
        System.out.println("\n--- Student Results ---");
        for (int i = 0; i < students; i++) {
            int avg = total[i] / subjects;
            System.out.println("Student " + (i + 1) + ": Total = " + total[i] +
                    ", Average = " + avg +
                    ", Grade = " + grades[i]);
        }

        scanner.close();
    }
}

