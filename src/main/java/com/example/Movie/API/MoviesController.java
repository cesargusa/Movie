package com.example.Movie.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import com.example.Movie.Model.Movie;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MoviesController {

    private ArrayList<Movie> movies = new ArrayList<Movie>(Arrays.asList(new Movie("Peaky Blinders", "2013", "1"),
            new Movie("Vikings", "2013", "2"), new Movie("Joker", "2019", "3"), new Movie("It", "2019", "4"),
            new Movie("Gladiator", "2000", "5"), new Movie("Vikingdom", "2013", "6")

    ));
    
    
    // GET METHOD
    @GetMapping("/movies")
    private ArrayList<Movie> GetAllMovies(
            @RequestParam(name = "title", defaultValue = "", required = false) String title,
            @RequestParam(name = "year", defaultValue = "", required = false) String year) {
        ArrayList<Movie> AllMovies = new ArrayList<Movie>();
        if (title.equals("") && year.equals(""))
            return movies;
        if (!title.equals("") && year.equals("")) {
            for (Movie element : movies) {
                if (element.getTitle().contains(title)) {
                    AllMovies.add(element);
                }
            }
            return AllMovies;
        }
        if (title.equals("") && !year.equals("")) {
            for (Movie element : movies) {
                if (element.getYear().contains(year)) {
                    AllMovies.add(element);
                }
            }
            return AllMovies;
        }
        if (!title.equals("") && !year.equals("")) {
            for (Movie element : movies) {
                if (element.getTitle().contains(title) && element.getYear().contains(year)) {
                    AllMovies.add(element);
                }
            }
            return AllMovies;
        }

        return null;

    }

    // GET/ID METHOD
    @GetMapping("/movies/{id}")
    private Movie FindById(@PathVariable("id") String id){
        for(Movie element : movies){
            if(element.getId().equals(id)) return element;
        }
        return null;
    }


    // POST METHOD
    @PostMapping("/movies")
    private Movie AddMovie(@RequestBody Movie NewMovie){
        movies.add(NewMovie);
        return NewMovie;
    }
    
    // PUT METHOD
    @PutMapping("movies/{id}")
    private Movie UpdateMovie(@RequestBody Movie UpdateMovie,@PathVariable("id") String id){
        for(Movie element : movies){
            if(element.getId().equals(id)){
                element.setId(UpdateMovie.getId());
                element.setTitle(UpdateMovie.getTitle());
                element.setYear(UpdateMovie.getYear());

                return element;
            }
        }
        return null;
    }

    //DELETE METHOD
    @DeleteMapping("movies/{id}")
    private void DeleteMovie(@PathVariable("id") String id){
        for(Movie element : movies){
            if(element.getId().equals(id)){
                movies.remove(element);
                break;
            }
        }
    }
    
    

    @GetMapping("/movies/text")
    public String Text(Locale locale){
        var messages = ResourceBundle.getBundle("i18n\\messages", locale);
        return messages.getString("peliculas");
    }

}
