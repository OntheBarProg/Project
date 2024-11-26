package group4ticketingsystem;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int option;
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler();
        File file = new File("StudentFile.txt");

        do{
            System.out.println("+---------------------------------------------------+");
            System.out.println("|                       MENU                        |");
            System.out.println("+---------------------------------------------------+");
            System.out.println("|  [1] - ADD RECORD                                 |");
            System.out.println("|  [2] - SEARCH RECORDS                             |");
            System.out.println("|  [3] - VIEW RECORDS                               |");
            System.out.println("|  [4] - EXIT                                       |");
            System.out.println("+---------------------------------------------------+");
            System.out.print("OPTION: ");
            option = scanner.nextInt();
            System.out.println("+---------------------------------------------------+");
                System.out.println();

            switch (option) {
                case 1:
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|   NEW RECORD                                                           |");
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("");
                    Student student = new Student("Doe", "John", "John Doe", "20231001", "Computer Science");
                    Offense offense1 = new Offense(1, "Cheating", 2, "Caught cheating during an exam.");
                    Offense offense2 = new Offense(2, "Plagiarism", 1, "Submitted plagiarized code.");
                    
                    
                    student.addOffense(offense1);
                    student.addOffense(offense2);

                    
                    System.out.println(student.getStudentDetails());
                    

                    
                    
                    fileHandler.WriteFile(student);
                    System.out.println("SUCCESSFULLY WRITTEN...");
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println();
                    break;

                case 2:
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|   SEARCH                                                               |");
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|   VIEW                                                                 |");
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("");
                    System.out.println("READING...");
                    fileHandler.ReadFile(file);
                    System.out.println("SUCCESSFULLY READ...");
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println();
                    break;
            
                default:
                    System.out.println("INVALID OPTION...");
                    break;
            }   
        }while(isRunning);


        // Student student = new Student("Doe", "John", "John Doe", "20231001", "Computer Science");
        // Offense offense1 = new Offense(1, "Cheating", 2, "Caught cheating during an exam.");
        // Offense offense2 = new Offense(2, "Plagiarism", 1, "Submitted plagiarized code.");
        
        
        // student.addOffense(offense1);
        // student.addOffense(offense2);

        
        // System.out.println(student.getStudentDetails());

        
        // FileHandler fileHandler = new FileHandler();
        // File file = new File("StudentFile.txt");
        
        
        // fileHandler.WriteFile(student);
        // System.out.println("Student details written to file.");
        // System.out.println();

        
        // System.out.println("Reading student details from file:");
        // fileHandler.ReadFile(file);

        // Student student1 = new Student("Dela Cruz", "John", "John Dela Cruz", "20231001", "Computer Science");
        // Offense offense3 = new Offense(1, "Bullying", 2, "Bullying one of his collegues.");
        // Offense offense4 = new Offense(2, "Plagiarism", 1, "Submitted plagiarized code.");

        // student1.addOffense(offense3);
        // student1.addOffense(offense4);

        // System.out.println(student.getStudentDetails());

        // FileHandler fileHandler1 = new FileHandler();
        // File file1 = new File("StudentFile.txt");
        
        // fileHandler1.WriteFile(student1);
        // System.out.println("Student details written to file.");
        // System.out.println();

        
        // System.out.println("Reading student details from file:");
        // fileHandler1.ReadFile(file1);

    }
}
