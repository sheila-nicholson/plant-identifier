// url: http://localhost:8080/

package com.sheilan.plant_identifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication
public class PlantIdentifierApplication {

	public static void main(String[] args) {
		
		
		// Load .env file
        Dotenv dotenv = Dotenv.load();
        
        // Set the environment variable for Spring to use
        System.setProperty("PLANT_API_KEY", dotenv.get("PLANT_API_KEY"));
		
		
		SpringApplication.run(PlantIdentifierApplication.class, args);
	}

}
