/*
 * This Spring Boot controller listens for POST requests from the search bar 
 * A search query is recieved, processed and the result is returned
 */


package com.sheilan.plant_identifier.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping

public class PlantSearchController  {

    // @GetMapping("getResponse")
    // public String getMethodName(@RequestParam String param) {
    //     return new String();
    // }
    

    // This controller listens for POST requests on the /search endpoint.
    @PostMapping("/search")
    // The @RequestBody annotation binds the form data sent from the front-end. The data is sent as JSON
    public ResponseEntity<String> searchInput(@RequestBody Map<String, String> input) {
        
        String plantType = input.get("query");
        
        
        // Process the plant type (do an API request)
        return ResponseEntity.ok("Search results for: " + plantType);
    }

    


}
