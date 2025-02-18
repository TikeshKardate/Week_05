/*
1️⃣2️⃣ Detect Duplicates in a CSV File
Read a CSV file and detect duplicate entries based on the ID column.
Print all duplicate records.
*/

package com.csv_file_handling.advancedproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DetectDuplicatesInCSV {

    public static void main(String[] args) {
        String csvFile = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\DetectDuplicates.csv"; // Path to your CSV file
        String line;
        String csvSplitBy = ",";

        Map<String, String> recordMap = new HashMap<>();
        Set<String> duplicateRecords = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header row
                    continue;
                }

                String[] fields = line.split(csvSplitBy);
                String id = fields[0].trim();
                String record = line.trim();

                if (recordMap.containsKey(id)) {
                    duplicateRecords.add(record);
                } else {
                    recordMap.put(id, record);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print duplicate records
        if (!duplicateRecords.isEmpty()) {
            System.out.println("Duplicate records found:");
            for (String record : duplicateRecords) {
                System.out.println(record);
            }
        } else {
            System.out.println("No duplicate records found.");
        }
    }
}
