package com.sheilan.plant_identifier;

public class Plant {


    // name attributes
    public String name;
    public String commonName;
    public String scientificName;
    public String otherName;

    public boolean edible;
    public boolean poisonous;
    public boolean indoors;


    public String cycle;
    public String watering;
    public String sunlight;
    public int hardiness;


    public Plant(String name){

        this.name = name;

    }


    public String printinfo(){

        StringBuilder info = new StringBuilder();
        info.append("Name: ").append(name).append("\n")
            .append("Common Name: ").append(commonName).append("\n")
            .append("Scientific Name: ").append(scientificName).append("\n")
            .append("Other Names: ").append(otherName).append("\n")
            // .append("Edible: ").append(edible ? "Yes" : "No").append("\n")
            // .append("Poisonous: ").append(poisonous ? "Yes" : "No").append("\n")
            // .append("Suitable for Indoors: ").append(indoors ? "Yes" : "No").append("\n")
            .append("Cycle: ").append(cycle).append("\n")
            .append("Watering Needs: ").append(watering).append("\n")
            .append("Sunlight Needs: ").append(sunlight).append("\n");
            // .append("Hardiness Zone: ").append(hardiness).append("\n");
        
        return info.toString();

    }





}
