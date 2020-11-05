package com.example.Movie.API;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.Movie.Model.Movie;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {
    
    private ArrayList<Movie> movies = new ArrayList<Movie>(Arrays.asList(
        new Movie("Peaky Blinders","2013","1"),
        new Movie("Vikings","2013","2"),
        new Movie("Joker","2019","3"),
        new Movie("It","2019","4"),
        new Movie("Gladiator","2000","5")
    ));


}
