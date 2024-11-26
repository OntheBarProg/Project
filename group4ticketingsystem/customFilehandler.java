package group4ticketingsystem;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class customFilehandler  {
    private File filelink;

    customFilehandler(File file){
        this.filelink = file;
    }


    public void WriteFile(Student student){
    try{
    FileWriter writing = new FileWriter(filelink,true);

        
        writing.append(student.getStudentDetails());
        writing.close();

    }
    catch(IOException e){
        System.out.println("File Error");
    }

}
    public void ReadFile(File file){
        try{
            FileReader reading = new FileReader("StudentFile.txt");

            int i;

            while((i=reading.read())!=-1){

                System.out.print((char)(i));
        
            }

            reading.close();
        }
            catch(IOException e){
                System.out.println("File Error");
            }


    }

}