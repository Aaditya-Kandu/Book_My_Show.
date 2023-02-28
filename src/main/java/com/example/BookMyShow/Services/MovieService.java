package com.example.BookMyShow.Services;

import com.example.BookMyShow.Convertors.MovieConvertor;
import com.example.BookMyShow.Entities.MovieEntity;
import com.example.BookMyShow.EntryDTOs.MovieEntryDTO;
import com.example.BookMyShow.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDTO movieEntryDTO) throws Exception{


        MovieEntity movieEntity = MovieConvertor.convertEnterDTOtoEntity(movieEntryDTO);

        movieRepository.save(movieEntity);

        return "Movie Added Successfully";
    }
}
