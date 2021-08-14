package com.example.songr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Capetalize {

    @GetMapping("/capitalize/{cap}")
    public String getCapetalize(Model model , @PathVariable String cap){

        model.addAttribute("cap" ,cap.toUpperCase() );
        return "capetalize.html";
    }
}
