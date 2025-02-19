/*Parse JSON and filter only those records where age > 25.*/
package com.json.practiceproblems.parsejsonandfilteronlythoserecordswhereagemorethan25;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class ParseJsonAndApplyFilter {
    public static void main(String[] args) {
        try{
            // creating object mapper to read json
            ObjectMapper objmapper = new ObjectMapper();

            // storing the object in json to list
            List<PersonData> data= objmapper.readValue(new File("D:\\Week_05\\Day_02\\src\\main\\java\\com\\json\\practiceproblems\\parsejsonandfilteronlythoserecordswhereagemorethan25\\data.json"),new TypeReference<List<PersonData>>(){});

            // filtered data
            for(PersonData pdata : data){
                if(pdata.getAge()>25){
                    System.out.println(pdata);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
