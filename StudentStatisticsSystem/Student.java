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
                     displayStudentMarks();
                     break;
                     
            }
        } while((choice != 4));
       }
        private static boolean isStringEmpty(String str) {
        return str == null || str.length() == 0;
       }
       
       private static double parseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return 0.0;
        }
       }
        
       private static double getMark(String mark) {
        if (isStringEmpty(mark)) {
            return 0;
        } else {
            return parseDouble(mark);
        }
       }
       
    private static void displayStudentMarks() {
        System.out.println("Unit: " + unitName);
        for (String[] student : students) {
            String lastName = student[0];
            String firstName = student[1];
            String id = student[2];
            double mark1 = getMark(student[3]);
            double mark2 = getMark(student[4]);
            double mark3 = getMark(student[5]);
            double totalMark = mark1 + mark2 + mark3;

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
