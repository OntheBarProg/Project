package group4ticketingsystem;

/**
 *
 * @author russel rome
 */
public class Person {
    private String lastName;
    private String firstName;

    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getFullName() {
        return lastName + " " + firstName; // Dynamically generate full name
    }

    public void setFullName(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
}

-----------
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

        return details.toString();
    }
}
--------
package group4ticketingsystem;

/**
 *
 * @author russel rome
 */
public class Offense {
    private int offenseID;
    private String category;
    private int degree;
    private String details;

    public Offense(int offenseID, String category, int degree, String details) {
        this.offenseID = offenseID;
        this.category = category;
        this.degree = degree;
        this.details = details;
    }

    // Getters, cuh

    public int getOffenseID() {
        return offenseID;
    }

    public String getCategory() {
        return category;
    }

    public int getDegree() {
        return degree;
    }

    public String details() {
        return details;
    }

    @Override
    public String toString() {
        return String.format("%-10d | %-15s | %-6d | %-30s", offenseID, category, degree, details);
    }
}

