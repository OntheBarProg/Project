package group4ticketingsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private File filelink;

    // Constructor that sets the file
    FileHandler(File file){
        this.filelink = file;
    }

    // Method to write student details to the file, cuh
    public void WriteFile(Student student){
        try (FileWriter writing = new FileWriter(filelink, true)) {
            writing.append(student.getStudentDetails());
        } catch(IOException e){
            System.out.println("FILE ERROR...");
        }
        System.out.println();
        System.out.println("SUCCESSFULLY ADDED.\n");
    }

    // Method to read the file with a progress bar, cuh
    public void ReadFile() {
        try (BufferedReader reading = new BufferedReader(new FileReader(filelink))) {
            long fileSize = filelink.length();
            if (fileSize == 0) {
                System.out.println("THE FILE IS EMPTY.");
                return;
            }
    
            long totalBytesRead = 0;
            String line;
            StringBuilder content = new StringBuilder();
    
            // Progress bar initialization, cuh
            System.out.println("READING...");
    
            while ((line = reading.readLine()) != null) {
                content.append(line).append("\n");
                totalBytesRead += line.getBytes().length + 1; // +1 for newline character
    
                // Update progress bar
                String progress = progressBar(50, totalBytesRead, 0, fileSize);
                System.out.print("\r" + progress); // Keep the progress bar on the same line

                try {
                    Thread.sleep(100); // Adjust this value to control the delay (100ms here)
                } catch (InterruptedException e) {
                    System.err.println("PROGRESS BAR INTERRUPTED...");
                }
            }
    
            // Ensure the progress bar reaches 100%
            System.out.print("\r" + progressBar(50, fileSize, 0, fileSize) + "\n");
    
            // Display the file content after the progress bar is complete
            System.out.println("\nFILE CONTENT:\n" + content.toString());
            System.out.println("SUCCESSFULLY READ...\n");
        } catch (IOException e) {
            System.out.println("FILE ERROR...");
        }
    }
    
    // Method to generate a text-based progress bar
    private String progressBar(int progressBarSize, long currentPosition, long startPosition, long finishPosition) {
        StringBuilder bar = new StringBuilder();
        int nPositions = progressBarSize;
        char pb = '░'; // Empty progress indicator
        char stat = '█'; // Filled progress indicator

        // Calculate the percentage completion
        int status = (int) ((100.0 * (currentPosition - startPosition)) / (finishPosition - startPosition));
        status = Math.max(0, Math.min(100, status)); // Clamp status to [0, 100]

        int move = (int) ((nPositions * status) / 100.0);
        move = Math.min(move, nPositions); // Ensure move is within bounds

        // Build the progress bar string
        bar.append("[");
        for (int p = 0; p < move; p++) {
            bar.append(stat);
        }
        for (int p = move; p < nPositions; p++) {
            bar.append(pb);
        }
        bar.append("] ").append(status).append("%");

        return bar.toString();
    }
}
