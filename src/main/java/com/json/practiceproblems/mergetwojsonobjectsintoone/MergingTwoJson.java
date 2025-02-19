/*Merge two JSON objects into one.*/
package com.json.practiceproblems.mergetwojsonobjectsintoone;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

public class MergingTwoJson {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        //creating the object
        JSONObject obj1= new JSONObject();
        //putting the key value in the object
        obj1.put("Name","Tikesh Kardate");
        obj1.put("Age",22);

        // creating the array of subjects
        JSONArray objArr = new JSONArray();
        objArr.put("RAC").put("AME").put("CLOUD");
        obj1.put("subjects",objArr);

        //creating the object
        JSONObject obj2= new JSONObject();
        //putting the key value in the object
        obj2.put("Email","tikesh@gmail.com");
        obj2.put("DOB","28-11-2002");

        obj2.keySet().forEach(key->obj1.put(key,obj2.get(key)));
        System.out.println(obj1.toString(5));
    }
}
