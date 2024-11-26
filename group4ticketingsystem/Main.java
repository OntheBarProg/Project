package group4ticketingsystem;


// import java.util.*;
// import java.io.*;

// public class Main {
//     public static void main(String[] args) {
//         int option;
//         boolean isRunning = true;
//         Scanner scanner = new Scanner(System.in);
//         File file = new File("StudentFile.txt");
//         FileHandler fileHandler = new FileHandler(file);
//         ArrayList<Student> StudentList = new ArrayList<>();

//         do{
//             System.out.println("+---------------------------------------------------+");
//             System.out.println("|                       MENU                        |");
//             System.out.println("+---------------------------------------------------+");
//             System.out.println("|  [1] - ADD RECORD                                 |");
//             System.out.println("|  [2] - SEARCH RECORDS                             |");
//             System.out.println("|  [3] - VIEW RECORDS                               |");
//             System.out.println("|  [4] - EXIT                                       |");
//             System.out.println("+---------------------------------------------------+");
//             System.out.print("OPTION: ");
//             option = scanner.nextInt();
//             scanner.nextLine();
//             System.out.println("+---------------------------------------------------+");
//                 System.out.println();

//             switch (option) {
//                 case 1:
//                     System.out.println("+------------------------------------------------------------------------+");
//                     System.out.println("|   NEW RECORD                                                           |");
//                     System.out.println("+------------------------------------------------------------------------+");
//                     System.out.println();

//                     System.out.print("Enter Student Last Name: ");
//                     String lastName = scanner.nextLine();
//                     System.out.print("Enter Student First Name: ");
//                     String firstName = scanner.nextLine();
//                     String fullName = firstName + " " + lastName;
//                     System.out.print("Enter Student Number (202XXXXXX): ");
//                     String studentNumber = scanner.nextLine();
//                     System.out.print("Enter Student Course: ");
//                     String courseProgram = scanner.nextLine();
//                     System.out.println();

//                     Student newStudent = new Student(lastName, firstName, fullName, studentNumber, courseProgram);
//                     StudentList.add(newStudent);

//                     System.out.print("Do you wanna add an offense [Y|N]: ");
//                     String offensechoice = scanner.nextLine();
//                     System.out.println();
//                     while(offensechoice.equalsIgnoreCase("Y")){
//                         System.out.print("Offense Category: ");
//                         String category = scanner.nextLine();
//                         System.out.print("Enter Offense Degree: ");
//                         int degree = scanner.nextInt();
//                         scanner.nextLine();
//                         System.out.print("Enter Offense Details: ");
//                         String details = scanner.nextLine();

//                         Offense newOffense = new Offense(category, degree, details);
//                         newStudent.addOffense(newOffense);

//                         System.out.println("Offense added");
//                         System.out.println(newStudent.getStudentDetails());
//                         System.out.println();
//                         System.out.print("Do you want to add another offense [Y|N]: ");
//                         offensechoice = scanner.nextLine();
//                     }
//                     fileHandler.WriteFile(newStudent);
//                     System.out.println("Student details written to file.");
//                     System.out.println("+---------------------------------------------------+");
//                     System.out.println();
//                     break;
                    

//                 case 2:
//                     System.out.println("+------------------------------------------------------------------------+");
//                     System.out.println("|   SEARCH                                                               |");
//                     System.out.println("+------------------------------------------------------------------------+");
//                     System.out.println("");
//                     break;

//                 case 3:
//                     System.out.println("+------------------------------------------------------------------------+");
//                     System.out.println("|   VIEW                                                                 |");
//                     System.out.println("+------------------------------------------------------------------------+");
//                     System.out.println("");
//                     System.out.println("READING...");
//                     fileHandler.ReadFile(file);
//                     System.out.println("SUCCESSFULLY READ...");
//                     System.out.println("+------------------------------------------------------------------------+");
//                     System.out.println();
//                     break;

//                 case 4:
//                     System.out.println("EXIT...");
//                     isRunning = false;
//                     break;
            
//                 default:
//                     System.out.println("INVALID OPTION...");
//                     break;
//             }   
//         }while(isRunning);
//     }
// }

import java.util.*;
import java.io.*;

public class Main {
    private static ArrayList<Student> StudentList = new ArrayList<>();
    private Scanner scanner = new Scanner (System.in);
    private File file = new File("StudentFile.txt");
    private FileHandler filehandler = new FileHandler(file);
    
    public Main(ArrayList<Student> StudentList, Scanner scanner, File file, FileHandler filehandler){
        this.StudentList = StudentList;
        this.scanner = scanner;
        this.file = file;
        this.filehandler = filehandler;
    }
    
    void main(){
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
            System.out.print("Offense Category: ");
            String category = scanner.nextLine();
            System.out.print("Enter Offense Degree: ");
            int degree = scanner.nextInt();
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
        //TODO 
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
