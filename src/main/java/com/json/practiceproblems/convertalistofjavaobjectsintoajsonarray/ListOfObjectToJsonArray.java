package com.json.practiceproblems.convertalistofjavaobjectsintoajsonarray;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;

public class ListOfObjectToJsonArray {
    public static void main(String[] args) {
        // creating the object and storing in the list
        Student s1 = new Student(101,"Tikesh","suraj@gmail.com");
        Student s2 = new Student(102,"Avhay","abhay@gmail.com");
        Student s3 = new Student(103,"Amaan","amaan@gmail.com");
        Student s4 = new Student(104,"Vivek","vivek@gmail.com");
        List<Student> studentData= new ArrayList<>();
        studentData.add(s1);
        studentData.add(s2);
        studentData.add(s3);
        studentData.add(s4);

        try{
            // it is used to convert object to json
            ObjectMapper obj = new ObjectMapper();
            // writerWithDefaultPrettyPrinter method is used to make our json format more readable
            String jsonString = obj.writerWithDefaultPrettyPrinter().writeValueAsString(studentData);
            System.out.println(jsonString);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
