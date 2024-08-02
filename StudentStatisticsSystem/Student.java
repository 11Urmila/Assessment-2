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
        readFromFile(filename);
        
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Compute and print student-wise marks");
            System.out.println("2. Filter and print students below threshold");
            System.out.println("3. Sort and print top 5 students with highest and lowest marks");
            System.out.println("4. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                 
            }
        } while((choice != 4));
       }
       
       private static void readFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue; 
                }

                String[] parts = line.split(",");
                if (parts.length == 1) {
                    unitName = parts[0];
                } else if (parts.length == 5) {
                    students.add(parts);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
