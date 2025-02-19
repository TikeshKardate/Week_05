package com.json.handsonpracticeproblems.validateemailfieldusingJSONschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

public class ValidateEmailFieldSONSchema {
    public static void main(String[] args) {
        String schema= """
        {
            "$schema": "http://json-schema.org/draft-07/schema#",
                "type": "object",
                "properties": {
            "name": { "type": "string" },
            "email": { "type": "string", "format": "email" }
        },
        "required": ["name", "email"]
        }
        """;
        String validJson = "{\"name\": \"Tikesh\", \"email\": \"tikesh@example.com\"}";
        String invalidJson = "{\"name\": \"Abhay\", \"email\": \"abhay@example.com\"}";

        //Try block
        try {

            ObjectMapper mapper = new ObjectMapper();
            JsonNode schemaNode = mapper.readTree(schema);
            JsonNode validJsonNode = mapper.readTree(validJson);
            JsonNode invalidJsonNode = mapper.readTree(invalidJson);

            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schemam = factory.getJsonSchema(schemaNode);

            // Validate valid JSON
            validateJson(schemam, validJsonNode);

            // Validate invalid JSON
            validateJson(schemam, invalidJsonNode);
        }
        //Catch Block
        catch (Exception e){
            System.out.println("Exception occured");
        }
    }
    //Method to validate JSON
    private static void validateJson(JsonSchema schema, JsonNode jsonNode) throws Exception {
        ProcessingReport report = schema.validate(jsonNode);
        if (report.isSuccess()) {
            System.out.println("JSON is valid: " + jsonNode);
        } else {
            System.out.println("JSON validation failed: ");
            report.forEach(msg -> System.out.println("Email " + msg.getMessage()));
        }
    }
}
