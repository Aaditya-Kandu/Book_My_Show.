package com.example.BookMyShow.Entities;

import com.example.BookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theater_seats")
@Data
@NoArgsConstructor
public class TheaterSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private String seatNo;

    // mapping theater entity and theaterSeat. In which theater is parent and theaterSeat is child
    @ManyToOne
    @JoinColumn
    TheaterEntity theaterEntity;

}