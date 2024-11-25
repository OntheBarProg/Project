package group4ticketingsystem;
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String args[]){
        Student student = new Student("Doe", "John", "John Doe", "20231001", "Computer Science");
        Offense offense1 = new Offense(1, "Cheating", 2, "Caught cheating during an exam.");
        Offense offense2 = new Offense(2, "Plagiarism", 1, "Submitted plagiarized code.");
        
        
        student.addOffense(offense1);
        student.addOffense(offense2);

        
        System.out.println(student.getStudentDetails());

        
        Filehandler fileHandler = new Filehandler();
        File file = new File("StudentFile.txt");
        
        
        fileHandler.WriteFile(student);
        System.out.println("Student details written to file.");

        
        System.out.println("Reading student details from file:");
        fileHandler.ReadFile(file);
    }
}