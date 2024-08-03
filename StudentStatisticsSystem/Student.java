import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Write a description of class Student here.
 *
 * @author Urmila
 * @version (a version number or a date)
 */
public class Student
{
       private static String unitName;
       private static List<String[]> students = new ArrayList<>();
        
       public static void main(String[] args)
       {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the filename: ");
        String filename = scanner.nextLine();
        readInputFromFile(filename);
        
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Compute and print student-wise marks");
            System.out.println("2. Filter and print students below threshold");
            System.out.println("3. Sort and print top 5 students with highest and lowest marks");
            System.out.println("4. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                 case 0:
                     printStudentMarks();
                     break;
                     
            }
        } while((choice != 4));
       }
        private static void printStudentMarks() {
        System.out.println("Unit: " + unitName);
        for (String[] student : students) {
            String lastName = student[0];
            String firstName = student[1];
            String id = student[2];
            int mark1 = student[3].isEmpty() ? 0 : Integer.parseInt(student[3]);
            int mark2 = student[4].isEmpty() ? 0 : Integer.parseInt(student[4]);
            int mark3 = student[5].isEmpty() ? 0 : Integer.parseInt(student[5]);
            int totalMark = mark1 + mark2 + mark3;

            System.out.println(firstName + " " + lastName + " (" + id + "): " +
                    mark1 + ", " + mark2 + ", " + mark3 +
                    " -> Total: " + totalMark);
        }
    }

        private static void readInputFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            unitName = br.readLine(); 
            br.readLine(); 
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) { 
                    students.add(parts);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
