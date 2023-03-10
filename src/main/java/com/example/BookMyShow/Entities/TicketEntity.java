package com.example.BookMyShow.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TicketEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String movieName;

    private String theaterName;

    private LocalTime showTime;

    private LocalDate shoDate;

   private int totalAmount;

   private String ticketId = UUID.randomUUID().toString();

   private String bookedSeats;

   // ticket is child wrt the user;

   @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

   // Ticket is child wrt to the show entity

    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;

}
