package group4ticketingsystem;

public class Offense {
    private static int offenceIDCounter = 0;
    private final int offenseID;
    private String category;
    private int degree;
    private String details;

    public Offense(String category, int degree, String details) {
        this.offenseID = ++offenceIDCounter;
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
        return String.format("|%-11d | %-15s | %-6d | %-31s|", offenseID, category, degree, details);
    }
}