import java.util.ArrayList;
import java.util.Scanner;

public class StudentGrades {

    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter grades of students (type '-1' to end):");
        while (true) {
            System.out.print("Enter grade: ");
            // Validate input to ensure an integer is entered
            if (scanner.hasNextInt()) {
                int grade = scanner.nextInt();
                if (grade == -1) {
                    break;
                } else if (grade < 0 || grade > 100) { // Assuming grades are between 0 and 100
                    System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
                } else {
                    grades.add(grade);
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input
            }
        }

        if (grades.isEmpty()) {
            System.out.println("No grades were entered.");
        } else {
            int highest = findHighest(grades);
            int lowest = findLowest(grades);
            double average = calculateAverage(grades);
            
            System.out.println("Highest grade: " + highest);
            System.out.println("Lowest grade: " + lowest);
            System.out.println("Average grade: " + average);
        }

        scanner.close();
    }

    public static int findHighest(ArrayList<Integer> grades) {
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public static int findLowest(ArrayList<Integer> grades) {
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    public static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
}
