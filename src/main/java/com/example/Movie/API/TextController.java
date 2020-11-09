package com.example.Movie.API;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TextController {
    
    @GetMapping("/movies/TextLanguage")
    public String Text(){
        return "idioma";
    }

    @GetMapping("/movies/Language")
    public String Language(){
        return "language";
    }
    @GetMapping("/movies/Buscador")
    public String Buscador(){
        return "buscador";
    }
 
}

