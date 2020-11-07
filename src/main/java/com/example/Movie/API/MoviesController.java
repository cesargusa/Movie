package com.example.Movie.API;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.Movie.Model.Movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {
    
   
     private ArrayList<Movie> movies = new ArrayList<Movie>(Arrays.asList(
        new Movie("Peaky Blinders","2013","1"),
        new Movie("Vikings","2013","2"),
        new Movie("Joker","2019","3"),
        new Movie("It","2019","4"),
        new Movie("Gladiator","2000","5"),
        new Movie("Vikingdom","2013","6")

       
    ));
    


  @GetMapping("/movies")
  private ArrayList<Movie> GetAllMovies(@RequestParam(name = "title", defaultValue = "", required = false) String title,
  @RequestParam(name = "year", defaultValue = "", required = false) String year){
      ArrayList<Movie> AllMovies = new ArrayList<Movie>();
        if(title.equals("") && year.equals("")) return movies;
        if(!title.equals("") && year.equals("")){
            for(Movie element : movies){
                if(element.getTitle().contains(title)){
                    AllMovies.add(element);
                }
            }
            return AllMovies;
        }
        if(title.equals("") && !year.equals("")){
            for(Movie element : movies){
                if(element.getYear().contains(year)){
                    AllMovies.add(element);
                }
            }
            return AllMovies;
        }
        if(!title.equals("") && !year.equals("")){
            for(Movie element: movies){
                if(element.getTitle().contains(title) && element.getYear().contains(year)){
                    AllMovies.add(element);
                }
            }
            return AllMovies;
        }


    return null;

  }
   
        
       

        }

    


    

