package com.json.iplandcensoranalyzer;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONIPLDataModifier {
    public static void jsonIPLDataModifier(File beforeCensorship , File afterCensorship){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            List<IPLMatch> dataIplMatch = objectMapper.readValue(beforeCensorship, new TypeReference<List<IPLMatch>>(){});
            List<IPLMatch> dataAfterIPLMatch = new ArrayList<>();

            for (IPLMatch match : dataIplMatch) {
                String team1 = match.getTeam1();
                String team2 = match.getTeam2();

                //Mask Team 1 Name
                String[] teamName1 = team1.split(" ");
                if (teamName1.length > 1) {
                    for (int i = 1; i < teamName1.length; i++) {
                        teamName1[i] = "***";
                    }
                }
                String maskedTeam1 = String.join(" ", teamName1);
                match.setTeam1(maskedTeam1);

                //Mask Team 2 Name
                String[] teamName2 = team2.split(" ");
                if (teamName2.length > 1) {
                    for (int i = 1; i < teamName2.length; i++) {
                        teamName2[i] = "***";
                    }
                }
                String maskedTeam2 = String.join(" ", teamName2);
                match.setTeam2(maskedTeam2);
                match.setPlayer_of_match("REDACTED");


                //Store modified match in the new list
                dataAfterIPLMatch.add(match);
            }

            //Write modified data to the new file
            WriteObjectToJson.writeObjectToJson(dataAfterIPLMatch, afterCensorship);

        } catch (StreamReadException | DatabindException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
