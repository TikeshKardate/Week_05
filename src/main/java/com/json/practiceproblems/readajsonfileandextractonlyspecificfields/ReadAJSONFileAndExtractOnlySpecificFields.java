package com.json.practiceproblems.readajsonfileandextractonlyspecificfields;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ReadAJSONFileAndExtractOnlySpecificFields {
    public static void main(String[] args) {
        //Try block
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Reading JSON file into JsonNode array
            JsonNode rootNode = objectMapper.readTree(new File("D:\\Week_05\\Day_02\\src\\main\\java\\com\\json\\practiceproblems\\readajsonfileandextractonlyspecificfields\\read.json"));

            // Iterating over each student and extracting name & email
            for (JsonNode node : rootNode) {
                String name = node.get("name").asText();
                String email = node.get("email").asText();
                System.out.println("Name: " + name + ", Email: " + email);
            }
        }
        //Catch block
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
