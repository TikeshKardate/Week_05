/*
1️⃣3️⃣ Generate a CSV Report from Database
Fetch employee records from a database and write them into a CSV file.
Include headers: Employee ID, Name, Department, Salary.
*/

package com.csv_file_handling.advancedproblems;

import java.io.*;

public class GenerateCSVFromDatabase {
    public static void main(String[] args) {
        String inputPath = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\GenerateCSV.txt";
        String outputPath = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\GenerateCsv.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

            bw.write("Employee ID,Name,Department,Salary\n");
            String s;
            while ((s = br.readLine()) != null) {
                bw.write(s.replace(" ", ",") + "\n");
            }

            System.out.println("CSV file generated successfully: " + outputPath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

