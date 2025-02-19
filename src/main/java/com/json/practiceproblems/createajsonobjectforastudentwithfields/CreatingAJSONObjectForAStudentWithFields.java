package com.json.practiceproblems.createajsonobjectforastudentwithfields;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreatingAJSONObjectForAStudentWithFields {
    public static void main(String[]args){
        // Creating json object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Tikesh");
        jsonObject.put("age", 22);
        // Creating json array to store subjects
        JSONArray subjects = new JSONArray();
        subjects.put("DBMS");
        subjects.put("OOPS");
        subjects.put("CLOUD");
        subjects.put("AI");
        jsonObject.put("subject", subjects);
        // Output
        System.out.println(jsonObject.toString(4));
    }
}
