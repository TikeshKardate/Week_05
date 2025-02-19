package com.json.handsonpracticeproblems.readaJSONfileandprintall;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ReadJSONFileAndPrintAll {
    public static void main(String[] args) {
        File file=new File("D:\\Week_05\\Day_02\\src\\main\\java\\com\\json\\handsonpracticeproblems\\readaJSONfileandprintall\\person.json");
        ObjectMapper objectMapper=new ObjectMapper();
        //Try block
        try {
            JsonNode jsonNode =objectMapper.readTree(file);
            System.out.println(jsonNode);
        }
        //Catch block
        catch (Exception e) {
            System.out.println("Exception occured");
        }
    }
}
