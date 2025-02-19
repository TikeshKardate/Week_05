package com.json.handsonpracticeproblems.parseJSONandfilter;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class ParseJSONAndFilter {
    public static void main(String[] args) {
        //Try block
        try {
            List<Student> students = new ArrayList<>();
            //Input
            Student s1 = new Student("Tikesh", 26, new String[]{"maths", "ioT", "cloud computing"});
            Student s2 = new Student("Abhay", 26, new String[]{"physics", "chemistry", "biology"});
            Student s3 = new Student("Nishank", 21, new String[]{"maths", "biology", "physics"});
            students.add(s1);
            students.add(s2);
            students.add(s3);

            JSONArray jsonArray = new JSONArray(students);

            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode rootNode = objectMapper.readTree(jsonArray.toString());
            ArrayNode filteredArray = objectMapper.createArrayNode();

            for (JsonNode jsonNode1 : rootNode) {
                if (jsonNode1.get("age").asInt()>25){
                    filteredArray.add(jsonNode1);
                }
            }
            System.out.println(filteredArray);
        }
        //Catch block
        catch (Exception e) {
            System.out.println("Exception occured");
        }
    }
}
