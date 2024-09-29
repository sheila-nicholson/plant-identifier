package com.sheilan.plant_identifier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
public class HomeWebController {

    @GetMapping({"/", "/index.html"})
    public String showHome() {
        
        // index is a ptr to the template we want to return --> i.e. index.html
        return "index";
    }

    @GetMapping({"/index"})
    public String showPlantSearch() {
        
        return "index";
    }

    @GetMapping({"/browse"})
    public String showBrowse() {
        
        return "browse";
    }

    @GetMapping({"/features"})
    public String showFeatures() {
        
        return "features";
    }

    @GetMapping({"/login"})
    public String showLogin() {
        
        return "login";
    }
    

}
