package com.example.BookMyShow.Services;

import com.example.BookMyShow.Convertors.ShowConvertor;
import com.example.BookMyShow.Entities.*;
import com.example.BookMyShow.EntryDTOs.ShowEntryDTO;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Repositories.MovieRepository;
import com.example.BookMyShow.Repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;


    public String addShow(ShowEntryDTO showEntryDTO){

        // Create show Entity:
        // make Show convertor class and set attribute by @Builder annotation and return it and used in service

        ShowEntity showEntity = ShowConvertor.convertEntrytoEntity(showEntryDTO);

        int movieId = showEntryDTO.getMovieId();
        int theaterId = showEntryDTO.getTheaterId();

        MovieEntity movieEntity = movieRepository.findById(movieId).get();

        TheaterEntity theaterEntity = theaterRepository.findById(theaterId).get();


        // setting the attribute for foreign key

        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);

        // Pending Attribute are ListOfShowSeatsEntity

        List<ShowSeatEntity> seatEntityList = createShowSeatsEntity(showEntryDTO,showEntity);

        showEntity.setTheaterEntity(theaterEntity);

        // Now we also need to update the parent entity

        List<ShowEntity> showEntityList = movieEntity.getShowEntityList();
        showEntityList.add(showEntity);
        movieEntity.setShowEntityList(showEntityList);

        movieRepository.save(movieEntity);

        List<ShowEntity> showEntityList1 = theaterEntity.getShowEntityList();
        showEntityList1.add(showEntity);
        theaterEntity.setShowEntityList(showEntityList1);

        theaterRepository.save(theaterEntity);


        return "The show has been added successfully";

    }

    private List<ShowSeatEntity> createShowSeatsEntity(ShowEntryDTO showEntryDTO, ShowEntity showEntity){


        //Now the goal is creates show seat entity
        // we need to set it attribute

        TheaterEntity theaterEntity = showEntity.getTheaterEntity();

        List<TheaterSeatEntity> theaterSeatEntityList = theaterEntity.getTheaterSeatEntityList();

        List<ShowSeatEntity> seatEntityList = new ArrayList<>();

        for(TheaterSeatEntity theaterSeatEntity : theaterSeatEntityList){

            ShowSeatEntity showSeatEntity = new ShowSeatEntity();

            showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());

            if(theaterSeatEntity.getSeatType().equals(SeatType.CLASSIC))
                showSeatEntity.setPrice(showEntryDTO.getClassicSeatPrice());

            else
                showSeatEntity.setPrice(showEntryDTO.getPremiumSeatPrice());

            showSeatEntity.setBooked(false);
            showSeatEntity.setShowEntity(showEntity);// Parent: Foreign key for the showSeat Entity

            seatEntityList.add(showSeatEntity); // Adding to the list

        }
        return seatEntityList;
    }
}
