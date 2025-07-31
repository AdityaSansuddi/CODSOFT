import java.util.Scanner;

public class GradeCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Grade Calculator ===");
        
        
        System.out.print("Enter the number of subjects: ");
        int n = scanner.nextInt();
        
        int totalMarks = 0;
        
        
        for (int i = 1; i <= n; i++) {
            int marks;
            while (true) {
                System.out.print("Enter marks for subject " + i + " (out of 100): ");
                marks = scanner.nextInt();
                if (marks >= 0 && marks <= 100) break; 
                System.out.println("Invalid marks! Enter between 0 and 100.");
            }
            totalMarks += marks;
        }

        
        double average = (double) totalMarks / n;

        
        String grade;
        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F (Fail)";
        }

        System.out.println("\n--- Results ---");
        System.out.println("Total Marks = " + totalMarks);
        System.out.printf("Average Percentage = %.2f%%\n", average);
        System.out.println("Grade = " + grade);

        scanner.close();
    }
}
