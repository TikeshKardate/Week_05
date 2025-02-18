/*
8️⃣ Validate CSV Data Before Processing
Ensure that the "Email" column follows a valid email format using regex.
Ensure that "Phone Numbers" contain exactly 10 digits.
Print any invalid rows with an error message.
*/

package com.csv_file_handling.advancedproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ValidatingCSV_File {
    public static void main(String[] args) {
        String csvFile = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem4_CSV_File.csv"; // CSV file path
        String line;
        String csvSplitBy = ","; // Delimiter for CSV

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] fields = line.split(csvSplitBy);
                String email = fields[0].trim();
                String phoneNumber = fields[1].trim();

                if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    System.out.println("Invalid email at line " + lineNumber + ": " + email);
                }
                if (!phoneNumber.matches("^\\d{10}$")) {
                    System.out.println("Invalid phone number at line " + lineNumber + ": " + phoneNumber);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
