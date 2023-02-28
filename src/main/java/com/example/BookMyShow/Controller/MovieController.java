package com.example.BookMyShow.Controller;

import com.example.BookMyShow.EntryDTOs.MovieEntryDTO;
import com.example.BookMyShow.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody()MovieEntryDTO movieEntryDTO){

        try {
            String response = movieService.addMovie(movieEntryDTO);

            return new ResponseEntity<>(response, HttpStatus.CREATED);

        }catch (Exception e){

            String response = "Movie not added";
            return new ResponseEntity<>(response , HttpStatus.BAD_REQUEST);
        }

    }
}
