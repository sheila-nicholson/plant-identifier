**Plant Identifier Project**
This project uses the Spring Boot framework to create a local web application that allows users to search for plants by name. The application retrieves detailed plant information from the Perenual Plant API.

**Installation & Setup**
1. Clone the repository.
2. Visit Perenual Plant API Docs to get an API key.
3. Set up your environment variables:
- create a .env file in the project
```bash
PLANT_API_KEY=your-api-key-here
```

**Running the Application via Command Line**
## Build the Project:

```bash
mvn compile 
```

## Run the Application:

```bash
mvn exec:java
```
## Terminate the Application:

```bash
ctrl-c
```

Once running, open your web browser and navigate to:
http://localhost:8080
Search for a plant, and detailed information will be displayed. Additional features are coming soon!


**Technologies Used**
Java (Spring Boot)
Perenual Plant API
Maven for project management
Bootstrap for frontend
