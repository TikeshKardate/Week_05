package com.json.handsonpracticeproblems.generateJSONreportfromdatabaserecords;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;

public class GenerateJSONReportFromDatabaseRecords {
    public static void main(String[] args) {
        //Try block
        try {
            // Database records as a list
            List<Student> students = Arrays.asList(
                    new Student("Tikesh", 22, "tikesh@example.com"),
                    new Student("Abhay", 22, "abhay@example.com"),
                    new Student("Amaan", 21, "amaan@example.com")
            );

            // Converting list to JSON and write to file
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("D:\\Week_05\\Day_02\\src\\main\\java\\com\\json\\handsonpracticeproblems\\generateJSONreportfromdatabaserecords\\students_report.json"), students);

            System.out.println("JSON report generated successfully!");
        }
        //Catch block
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
