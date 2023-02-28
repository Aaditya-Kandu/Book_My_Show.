package com.example.BookMyShow.EntryDTOs;

import com.example.BookMyShow.Enums.Languages;
import com.example.BookMyShow.Enums.MovieTypes;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class MovieEntryDTO {


    private String movieName;

    private double rating;

    private int duration;


    private Languages languages;


    private MovieTypes movieTypes;
}
