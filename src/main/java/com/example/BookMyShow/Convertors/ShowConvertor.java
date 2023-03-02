package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.Entities.ShowEntity;
import com.example.BookMyShow.EntryDTOs.ShowEntryDTO;

public class ShowConvertor {

    public static ShowEntity convertEntrytoEntity(ShowEntryDTO showEntryDTO){


        ShowEntity showEntity = ShowEntity.builder()
                .showDate(showEntryDTO.getLocalDate())
                .showTime(showEntryDTO.getLocalTime())
                .showType(showEntryDTO.getShowType())
                .build();

        return showEntity;
    }
}
