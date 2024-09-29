/*
 * This Spring Boot controller listens for POST requests from the search bar 
 * A search query is recieved, processed and the result is returned
 */


package com.sheilan.plant_identifier.controller;



import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sheilan.plant_identifier.Plant;






@RequestMapping
@Controller
public class PlantSearchController  {

    // @GetMapping("getResponse")
    // public String getMethodName(@RequestParam String param) {
    //     return new String();
    // }

    @Value("${PLANT_API_KEY}")
    private String apiKey;
    


    // This controller listens for POST requests on the /search endpoint.
    @PostMapping("/search")
    // The @RequestBody annotation binds the form data sent from the front-end. The data is sent as JSON
    public ResponseEntity<String> searchInput(@RequestBody Map<String, String> input) throws URISyntaxException {
        



        try {

            // create API url request
            String plantInput = input.get("query");

            String completeURL = "https://perenual.com/api/species-list?key=" + apiKey + "&q=" + plantInput;
            URI uriString = new URI(completeURL);
            URL url = uriString.toURL();

            // create a connection - GET request to API
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // check if connection is made
            int responseCode = conn.getResponseCode();

            if (responseCode != 200){
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                String apiResponse = "";
                Scanner scanner = new Scanner(url.openStream());
              
               //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                   apiResponse += scanner.nextLine();
                }
                
                //Close the scanner
                scanner.close();


                // System.out.println(apiResponse);


                JSONParser parser = new JSONParser();
                JSONObject plantJSON = (JSONObject) parser.parse(apiResponse);

                // Extract the 'data' array from the JSON response
                JSONArray plantsArray = (JSONArray) plantJSON.get("data");

                Plant inputPlant = new Plant(plantInput); 

                // Assuming you're only interested in the first plant in the array
                if (plantsArray != null && !plantsArray.isEmpty()) {
                    JSONObject plantJSON1 = (JSONObject) plantsArray.get(0); // Get the first plant object

                    inputPlant.commonName = (String) plantJSON1.get("common_name");
                
                    // scientific name --> array
                    JSONArray scientificNames = (JSONArray) plantJSON1.get("scientific_name");
                    if (scientificNames != null && !scientificNames.isEmpty()) {
                        inputPlant.scientificName = (String) scientificNames.get(0); // Get the first scientific name as a String
                    } else {
                        inputPlant.scientificName = ""; // Default value if no scientific name
                    }
                
                    // other names --> array
                    JSONArray otherNamesArray = (JSONArray) plantJSON1.get("other_name");
                    if (otherNamesArray != null && !otherNamesArray.isEmpty()) {
                        inputPlant.otherName = (String) otherNamesArray.get(0); // Get the first other name as a String
                    } else {
                        inputPlant.otherName = ""; // Default value if no other names
                    }
                
                    inputPlant.cycle = (String) plantJSON1.get("cycle");
                    inputPlant.watering = (String) plantJSON1.get("watering");
                
                    // sunlight --> array
                    JSONArray sunlightArray = (JSONArray) plantJSON1.get("sunlight");
                    if (sunlightArray != null && !sunlightArray.isEmpty()) {
                        inputPlant.sunlight = (String) sunlightArray.get(0); // Get the first sunlight requirement
                    } else {
                        inputPlant.sunlight = ""; // Default value if no sunlight information
                    }

                }


                return ResponseEntity.ok(inputPlant.printinfo());
            }
        
        
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred while fetching data.");
        }
        
    }

    


}
