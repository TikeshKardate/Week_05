package com.json.handsonpracticeproblems.convertCSVtoJSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;


public class ConvertCSVToJSON {
    //Method to convert CSV to JSON
    public static void convertCSVToJSON(String csvFilePath, String jsonFilePath) {
        //Try block
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
             FileWriter writer = new FileWriter(jsonFilePath)) {

            String[] headers = br.readLine().split(",");
            JSONArray jsonArray = new JSONArray();
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                JSONObject jsonObject = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i], data[i]);
                }
                jsonArray.put(jsonObject);
            }

            writer.write(jsonArray.toString(4));
        }
        //Catch block
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //File path
        String csvFilePath="D:\\Week_05\\Day_02\\src\\main\\java\\com\\json\\handsonpracticeproblems\\convertCSVtoJSON\\sampleData.csv";
        String jsonFilePath="D:\\Week_05\\Day_02\\src\\main\\java\\com\\json\\handsonpracticeproblems\\convertCSVtoJSON\\person.json";

        //Calling method
        convertCSVToJSON(csvFilePath,jsonFilePath);
    }
}
