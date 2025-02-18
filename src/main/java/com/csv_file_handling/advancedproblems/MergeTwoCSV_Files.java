/*
🔟 Merge Two CSV Files
You have two CSV files:
students1.csv (contains ID, Name, Age)
students2.csv (contains ID, Marks, Grade)
Merge both files based on ID and create a new file containing all details.
*/

package com.csv_file_handling.advancedproblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeTwoCSV_Files {

    public static void main(String[] args) {
        String students1File = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\MergeStudentsCSV_1.csv";
        String students2File = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\MergeStudentsCSV_2.csv";
        String outputFile = "merged_students.csv";

        Map<String, String[]> studentMap = new HashMap<>();

        // Read the first CSV file and store data in the map
        try (BufferedReader br = new BufferedReader(new FileReader(students1File))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header row
                    continue;
                }
                String[] fields = line.split(",");
                String id = fields[0].trim();
                String name = fields[1].trim();
                String age = fields[2].trim();
                studentMap.put(id, new String[]{name, age});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read the second CSV file and merge data
        try (BufferedReader br = new BufferedReader(new FileReader(students2File))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header row
                    continue;
                }
                String[] fields = line.split(",");
                String id = fields[0].trim();
                String marks = fields[1].trim();
                String grade = fields[2].trim();

                if (studentMap.containsKey(id)) {
                    String[] studentData = studentMap.get(id);
                    studentMap.put(id, new String[]{studentData[0], studentData[1], marks, grade});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the merged data to the output CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            // Write header
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            // Write data rows
            for (Map.Entry<String, String[]> entry : studentMap.entrySet()) {
                String id = entry.getKey();
                String[] fields = entry.getValue();
                bw.write(String.join(",", id, fields[0], fields[1], fields[2], fields[3]));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("CSV files merged successfully!");
    }
}
