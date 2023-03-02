package com.example.BookMyShow.Services;

import com.example.BookMyShow.Convertors.TheaterConverter;
import com.example.BookMyShow.Entities.TheaterEntity;
import com.example.BookMyShow.Entities.TheaterSeatEntity;
import com.example.BookMyShow.EntryDTOs.TheaterEntryDTO;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Repositories.TheaterRepository;
import com.example.BookMyShow.Repositories.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;


    public String addTheater(TheaterEntryDTO theaterEntryDTO) throws Exception{

        // Do some validation
        if(theaterEntryDTO.getName() == null || theaterEntryDTO.getLocation() == null)
            throw new Exception("Name & Location should not valid");

        TheaterEntity theaterEntity = TheaterConverter.convertDTOtoEntity(theaterEntryDTO);

        List<TheaterSeatEntity> theaterSeatEntityList =createTheaterSeats(theaterEntryDTO,theaterEntity);

        theaterEntity.setTheaterSeatEntityList(theaterSeatEntityList);

        theaterRepository.save(theaterEntity);


        return "Theater Added Successfully";

    }

    private List<TheaterSeatEntity> createTheaterSeats(TheaterEntryDTO theaterEntryDTO,TheaterEntity theaterEntity){

        int noOfClassicSeats = theaterEntryDTO.getClassicSeatsCount();
        int noOfPremiumSeats = theaterEntryDTO.getPremiumSeatsCount();

        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

        // Create classic seats here and add in list
        for(int count = 1; count <= noOfClassicSeats; count++){

            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder().seatType(SeatType.CLASSIC).
                                                    seatNo(count+"C").
                                                  theaterEntity(theaterEntity) . build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        // let us here add premium seats

        for(int count = 1; count <= noOfPremiumSeats; count++){

            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder().seatType(SeatType.PREMIUM).
                    seatNo(count + "P").
                    theaterEntity(theaterEntity) . build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        //theaterSeatRepository.saveAll(theaterSeatEntityList);

        return theaterSeatEntityList;

    }
}
