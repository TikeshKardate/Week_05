package com.json.handsonpracticeproblems.convertjavaobjecttojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class ConvertJavaObjectToJSON {
    public static void main(String[] args) {
        //Try block
        try {
            List<Student> students = new ArrayList<>();
            //Input
            Student s1 = new Student("Tikesh", 22, new String[]{"maths", "ioT", "cloud computing"});
            Student s2 = new Student("Abhay", 22, new String[]{"physics", "chemistry", "biology"});
            Student s3 = new Student("Amaan", 23, new String[]{"maths", "biology", "physics"});
            students.add(s1);
            students.add(s2);
            students.add(s3);
            JSONArray jsonArray=new JSONArray(students);
            //Output
            System.out.println(jsonArray);
        }
        //Catch block
        catch (Exception e) {
            System.out.println("Exception occured");
        }
    }
}
