/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca.s23234;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author 23424
 */
public class CAS23234 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            try {
            // Create a BufferedReader object to read from the "students.txt" file
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            // Create a BufferedWriter object to write to the "status.txt" fi1e
            BufferedWriter writer = new BufferedWriter(new FileWriter("status.txt"));
            String line;
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Split the string into first and last name
                String[] nameParts = line.split(" ");
                String firstName = nameParts[0];
                String secondName = nameParts[1];
                // Read the number of classes and student number
                int classes = Integer.parseInt(reader.readLine());
                String studentNumber = reader.readLine();

                // Checking data validity
                if (!firstName.matches("[a-zA-Z]+") || !secondName.matches("[a-zA-Z0-9]+") || 
                        classes < 1 || classes > 8 || !studentNumber.matches("\\d{2}[a-zA-Z]+\\d+")) {
                    // Display an error message if the data is invalid
                    System.out.println("Invalid data for student " + firstName + " " + secondName);
                    continue;
                }

                // Determine the student load depending on the number of classes
                String workload;
                if (classes == 1) {
                    workload = "very light";
                } else if (classes == 2) {
                    workload = "light";
                } else if (classes >= 3 && classes <= 5) {
                    workload = "part time";
                } else {
                    workload = "full time";
                }

                // Write to the "status.txt"
                writer.write(studentNumber + " - " + secondName + "\n" + workload + "\n\n");
            }
            // Close read and write
            reader.close();
            writer.close();
        } catch (IOException e) {
            // Handle I/O exception
            e.printStackTrace();
        }
    }
}
