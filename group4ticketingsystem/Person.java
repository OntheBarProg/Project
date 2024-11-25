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