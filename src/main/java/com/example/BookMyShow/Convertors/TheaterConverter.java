package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.Entities.TheaterEntity;
import com.example.BookMyShow.EntryDTOs.TheaterEntryDTO;

public class TheaterConverter {

    public static TheaterEntity convertDTOtoEntity(TheaterEntryDTO theaterEntryDTO){

        TheaterEntity theaterEntity = TheaterEntity.builder().name(theaterEntryDTO.getName()).
                                        location(theaterEntryDTO.getLocation()).
                                        build();

        return theaterEntity;
    }
}
