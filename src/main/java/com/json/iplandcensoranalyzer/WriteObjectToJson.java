package com.json.iplandcensoranalyzer;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WriteObjectToJson {
    public static void writeObjectToJson(List<IPLMatch> datatoWrite, File path) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Enable pretty-printing
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            //Writing data to JSON file
            objectMapper.writeValue(path, datatoWrite);
            System.out.println("Data Written Successfully");
        } catch (StreamWriteException | DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
