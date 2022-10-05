package com.example.springshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {

    @GetMapping("/dostav")
    public String getDostav(){
        return "dostav";
    }

    @GetMapping("/akcii")
    public String getAkcii(){
        return "akcii";
    }

    @GetMapping("/magazine")
    public String getMagazine(){
        return "magazine";
    }

    @GetMapping("/obrs")
    public String getObrs(){
        return "obrs";
    }


}
