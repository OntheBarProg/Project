package group4ticketingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author russel rome
 */
public class Student extends Person{
    public String studentNumber;
    public String courseProgram;
    private List<Offense> offenses;

    public Student(String lastName, String firstName, String fullName, String studentNumber, String courseProgram) {
        super(lastName, firstName);
        this.studentNumber = studentNumber;
        this.courseProgram = courseProgram;
        this.offenses = new ArrayList<>();
    }

    // Method para mag add ng violation(s)/offense(s), cuh
    public void addOffense(Offense offense) {
        offenses.add(offense);
    }

    public String getStudentDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Student Number: ").append(studentNumber).append("\n")
               .append("Full Name: ").append(getFullName()).append("\n")
               .append("Course Program: ").append(courseProgram).append("\n\n");
        
        // SQL-like table for offenses, cuh
        details.append("+------------+-----------------+--------+--------------------------------+\n");
        details.append("| Offense ID | Category        | Degree | Details                        |\n");
        details.append("+------------+-----------------+--------+--------------------------------+\n");
        for (Offense offense : offenses) {
            details.append(offense.toString()).append("\n");
        }
        details.append("+------------+-----------------+--------+--------------------------------+\n");
        details.append("+------------------------------------------------------------------------+\n");
        details.append("\n");
        details.append("\n");


        return details.toString();

        
        }

        @Override
        public void studentNum(){
            System.out.println("Student Number " + studentNumber);
        }
        
    }

    
