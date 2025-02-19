package com.json.iplandcensoranalyzer;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Class to modify the CSV File
public class CSVIPLDataModifier {
    //Method to modify CSV file
    public static void csvIplDataModifier(File beforeCensor, File afterCensor){
        //By using CSV Reader and Writer
        try(CSVReader reader = new CSVReader(new FileReader(beforeCensor));
            CSVWriter writer = new CSVWriter(new FileWriter(afterCensor))
        ) {//Not added the header line
            String []data = reader.readNext();
            //To store the updated data
            List<String []> playerdata = new ArrayList<>();
            //Extracting information
            while((data = reader.readNext())!= null){
               String player1= data[1];
               String[] teamName1 = player1.split(" ");
               //Updating the name
                if (teamName1.length > 1) {
                    for (int i = 1; i < teamName1.length; i++) {
                        teamName1[i] = "***";
                    }
                }
                String maskedTeam1 = String.join(" ", teamName1);
                data[1] = maskedTeam1;

                //Updating the name of player two
                String player2= data[2];
                String[] teamName2 = player1.split(" ");
                if (teamName1.length > 1) {
                    for (int i = 1; i < teamName1.length; i++) {
                        teamName1[i] = "***";
                    }
                }
                String maskedTeam2 = String.join(" ", teamName1);
                data[2] = maskedTeam1;

                data[data.length-1] = "REDACTED";
                //Add updated data to list
                playerdata.add(data);

                //System.out.println(Arrays.toString(data));
            }
            //Calling CSV writer to write data to the CSV file
            writer.writeAll(playerdata);
            System.out.println("Successs CSV updated");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
