package group4ticketingsystem;

import java.util.*;
import java.io.*;

public class Main {
    private static ArrayList<Student> StudentList = new ArrayList<>();
    private Scanner scanner = new Scanner (System.in);
    private File file = new File("StudentFile.txt");
    private FileHandler filehandler = new FileHandler(file);
    
    public Main(ArrayList<Student> StudentList, Scanner scanner, File file, FileHandler filehandler) {
        this.StudentList = StudentList;
        this.scanner = scanner;
        this.file = file;
        this.filehandler = filehandler;
    }
    
    void main() {
        System.out.println("+---------------------------------------------------+");
        System.out.println("|                       MENU                        |");
        System.out.println("+---------------------------------------------------+");
        System.out.println("|  [1] - ADD RECORD                                 |");
        System.out.println("|  [2] - SEARCH RECORDS                             |");
        System.out.println("|  [3] - VIEW RECORDS                               |");
        System.out.println("|  [4] - EXIT                                       |");
        System.out.println("+---------------------------------------------------+");
        System.out.print("OPTION: ");
    }
    
    void addRecord(){
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("|   NEW RECORD                                                           |");
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println();

        System.out.print("Enter Student Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Student First Name: ");
        String firstName = scanner.nextLine();
        String fullName = firstName + " " + lastName;
        System.out.print("Enter Student Number (202XXXXXX): ");
        String studentNumber = scanner.nextLine();
        System.out.print("Enter Student Course: ");
        String courseProgram = scanner.nextLine();
        System.out.println();

        Student newStudent = new Student(lastName, firstName, fullName, studentNumber, courseProgram);
        StudentList.add(newStudent);

        System.out.print("Do you wanna add an offense [Y|N]: ");
        String offensechoice = scanner.nextLine();
        System.out.println();
        while(offensechoice.equalsIgnoreCase("Y")){
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("|   OFFENSES                                                             |");
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("|   ACADEMICS                                                            |");
            System.out.println("|   C       -   Cheating                                                 |");
            System.out.println("|   IDOAM   -   Illegal Distribution of Academic Materials               |");
            System.out.println("|   MOAM    -   Misuse of Academic Materials                             |");
            System.out.println("|   P       -   Plagiarism                                               |");
            System.out.println("|                                                                        |");
            System.out.println("|   SOCIAL                                                               |");
            System.out.println("|   B       -   Bullying                                                 |");
            System.out.println("|   CB      -   Cyber Bullying                                           |");
            System.out.println("|   SA      -   Sexual Assault                                           |");
            System.out.println("|                                                                        |");
            System.out.println("|   INSTITUTIONAL                                                        |");
            System.out.println("|   POF     -   Pocession of Fire Arms                                   |");
            System.out.println("|   S|V     -   Smoking | Vaping                                         |");
            System.out.println("|   DOSP    -   Destruction of School Property                           |");
            System.out.println("|   IWOIU   -   Improper Wearing of Institutional Uniform [M|TH]         |");
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println();
            System.out.print("Offense Category: ");
            String category = scanner.nextLine();
            System.out.println();
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("|   DEGREE OF OFFENSE                                                    |");
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("| LEVEL | SEVERITY     | DESCRIPTION                                     |");
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("|  1    | Minor        | Minor infractions causing minimal harm or       |");
            System.out.println("|       |              | disruption. Typically results in a warning.     |");
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("|  2    | Moderate     | Infractions causing mild harm or disruption.    |");
            System.out.println("|       |              | Require formal warnings or corrective actions.  |");
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("|  3    | Significant  | Serious offenses negatively impacting others.   |");
            System.out.println("|       |              | Result in disciplinary action.                  |");
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("|  4    | Severe       | Severe offenses causing serious harm or         |");
            System.out.println("|       |              | major breaches of rules. May lead to legal      |");
            System.out.println("|       |              | actions or suspension.                          |");
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("|  5    | Critical     | Extremely serious offenses causing substantial  |");
            System.out.println("|       |              | harm. Often result in expulsion or criminal     |");
            System.out.println("|       |              | prosecution.                                    |");
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println();
            System.out.print("Enter Offense Degree: ");
            int degree = scanner.nextInt();
            System.out.println();
            scanner.nextLine();
            System.out.print("Enter Offense Details: ");
            String details = scanner.nextLine();

            Offense newOffense = new Offense(category, degree, details);
            newStudent.addOffense(newOffense);

            System.out.println("Offense added");
            System.out.println(newStudent.getStudentDetails());
            System.out.println();
            System.out.print("Do you want to add another offense [Y|N]: ");
            offensechoice = scanner.nextLine();
        }
        filehandler.WriteFile(newStudent);
        System.out.println("SUCCESSFULLY WRITTEN...");
        System.out.println("+---------------------------------------------------+");
        System.out.println();
    }
    
    void searchRecords(){
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("|   SEARCH                                                               |");
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println(""); 
    }
    
    void viewRecords () {
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("|   VIEW                                                                 |");
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("");
        filehandler.ReadFile();
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println();
    }

    void start() {
        boolean isRunning = true;
        do{
            main();
            int option = scanner.nextInt(); scanner.nextLine();
            System.out.println("+---------------------------------------------------+");
            System.out.println();
            switch(option){
                case 1:
                    addRecord();
                    break;
                case 2:
                    searchRecords();
                    break;
                case 3:
                    viewRecords();
                    break;
                case 4:
                    System.out.println("EXIT...");
                    scanner.close();
                    System.exit(0);
                    isRunning = false;
                    break;
                default:
                    System.out.println("INVALID OPTION...");
                    break;    
            }
        }while(isRunning);
    }
    
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("StudentFile.txt");
        FileHandler filehandler = new FileHandler(file);
        Main program = new Main(StudentList, scanner, file, filehandler);
        program.start();
    }
}
