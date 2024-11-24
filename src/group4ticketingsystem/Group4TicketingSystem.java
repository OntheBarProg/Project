
package group4ticketingsystem;
import java.io.*;
import java.util.*;

public class Group4TicketingSystem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> sdnt = new ArrayList<>();
        int chc = 0;
        do{
        //main menu
        System.out.println("Menu");
        System.out.println("--------------");
        System.out.println("[1] Add Record");
        System.out.println("[2] View Record");
        System.out.println("[3] Edit Record");
        System.out.println("--------------");
        
        
        //user input
        chc = scan.nextInt();
        scan.nextLine();
        
        
        switch(chc)
        {
            case 1:
                System.out.println("");
                break;
            case 2:
                break;
            case 3:
                break;
                
        }
        
        
        }
        while(chc!=4);
        
    }
    
}
