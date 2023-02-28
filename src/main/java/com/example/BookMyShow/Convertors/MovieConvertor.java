package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.Entities.MovieEntity;
import com.example.BookMyShow.EntryDTOs.MovieEntryDTO;

public class MovieConvertor {

    public static MovieEntity convertEnterDTOtoEntity(MovieEntryDTO movieEntryDTO){

        MovieEntity movieEntity = MovieEntity.builder().
                                    movieName(movieEntryDTO.getMovieName()).
                                    duration(movieEntryDTO.getDuration()).
                                    movieTypes(movieEntryDTO.getMovieTypes()).
                                    languages(movieEntryDTO.getLanguages()).
                                    rating(movieEntryDTO.getRating()).build();

            return movieEntity;


    }
}
