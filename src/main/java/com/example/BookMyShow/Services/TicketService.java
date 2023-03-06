package com.example.BookMyShow.Services;

import com.example.BookMyShow.Convertors.TicketConvertor;
import com.example.BookMyShow.Entities.ShowEntity;
import com.example.BookMyShow.Entities.ShowSeatEntity;
import com.example.BookMyShow.Entities.TicketEntity;
import com.example.BookMyShow.Entities.UserEntity;
import com.example.BookMyShow.EntryDTOs.TicketEntryDTO;
import com.example.BookMyShow.Repositories.ShowRepository;
import com.example.BookMyShow.Repositories.TicketRepository;
import com.example.BookMyShow.Repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    public String addTicket(TicketEntryDTO ticketEntryDTO) throws Exception{

        // convert Entity DTO to Entity
        TicketEntity ticketEntity = TicketConvertor.convertEntrytoDTO(ticketEntryDTO);

        //Validation: Checking for Requested seat is available or not

        boolean isValidRequest = checkValidityofRequestedSeats(ticketEntryDTO);

        if(isValidRequest == false){
            throw new Exception("Requested Seats are not available");
        }

        // If above(if) condition is not true means seats are available
        // Now calculate the price of Ticket

        ShowEntity showEntity = showRepository.findById(ticketEntryDTO.getShowId()).get();

        List<ShowSeatEntity> seatEntityList = showEntity.getListOfShowSeat();

        List<String> requestedSeat = ticketEntryDTO.getRequestedSeat();

        int totalAmount = 0;

        for (ShowSeatEntity showSeatEntity : seatEntityList) {

            if (requestedSeat.contains(showSeatEntity.getSeatNo())) {
                totalAmount = totalAmount + showSeatEntity.getPrice();
                showSeatEntity.setBooked(true);
                showSeatEntity.setBookedAt(new Date());
            }
        }

            ticketEntity.setTotalAmount(totalAmount);

            // Set the other Entity of TicketEntity
            ticketEntity.setMovieName(showEntity.getMovieEntity().getMovieName());
            ticketEntity.setShoDate(showEntity.getShowDate());
            ticketEntity.setShowTime(showEntity.getShowTime());
            ticketEntity.setTheaterName(showEntity.getTheaterEntity().getName());


            // we need to set that string that talk about requested seats

            String allotedSeats = getAllotedSeatsfromShowSeats(requestedSeat);
            ticketEntity.setBookedSeats(allotedSeats);

            // Setting the foreign key attribute

            UserEntity userEntity = userRepository.findById(ticketEntryDTO.getUseId()).get();

            ticketEntity.setUserEntity(userEntity);
            ticketEntity.setShowEntity(showEntity);

            // Save the parents

            List<TicketEntity> ticketEntityList = showEntity.getListOfBookedTickets();
            ticketEntityList.add(ticketEntity);
            showEntity.setListOfBookedTickets(ticketEntityList);
            showRepository.save(showEntity);

            List<TicketEntity> ticketEntityList1 = userEntity.getBookedTickets();
            ticketEntityList1.add(ticketEntity);
            userEntity.setBookedTickets(ticketEntityList1);
            userRepository.save(userEntity);


            return "Ticket Added Successfully";



        //}





    }

    public String getAllotedSeatsfromShowSeats(List<String> requestedSeat){

        String result = "";

        for(String seat : requestedSeat){

            result = result + seat + " ,";

        }
        return result;

    }

    public boolean checkValidityofRequestedSeats(TicketEntryDTO ticketEntryDTO){

        int showId = ticketEntryDTO.getShowId();

        List<String> requestedSeat = ticketEntryDTO.getRequestedSeat();

        ShowEntity showEntity = showRepository.findById(showId).get();

        List<ShowSeatEntity> listOfSeats = showEntity.getListOfShowSeat();

        // Iterating for list of Seat for that particular show

        for(ShowSeatEntity showSeatEntity : listOfSeats){

            String seatNo = showSeatEntity.getSeatNo();

            if(requestedSeat.contains(seatNo)){

                if(showSeatEntity.isBooked() == true)
                    return false;
            }
        }

        return true;

    }


}
