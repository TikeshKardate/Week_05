/*
9️⃣ Convert CSV Data into Java Objects
Read a CSV file and convert each row into a Student Java object.
Store the objects in a List<Student> and print them.
*/

package com.csv_file_handling.advancedproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertCSVDataToObjects {

        public static void main(String[] args) {
        String csvFile = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\CSVDataToObjects.csv"; // Path to your CSV file
        String line;
        String csvSplitBy = ",";

        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header row
                    continue;
                }
                String[] fields = line.split(csvSplitBy);
                String name = fields[0].trim();
                int age = Integer.parseInt(fields[1].trim());
                String email = fields[2].trim();
                String phoneNumber = fields[3].trim();

                Student student = new Student(name, age, email, phoneNumber);
                students.add(student);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Print the list of students
        for (Student student : students) {
            System.out.println(student);
        }
    }
    }


class Student {
    private String name;
    private int age;
    private String email;
    private String phoneNumber;

    public Student(String name, int age, String email, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

