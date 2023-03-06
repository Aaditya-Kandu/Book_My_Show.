package com.example.BookMyShow.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theater")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String location;

    private String bookedSeat;

    //mapping in parent class.

    @OneToMany(mappedBy = "theaterEntity" , cascade = CascadeType.ALL)
    private List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

    // It is parent wrt the show Entity.

    @OneToMany(mappedBy = "theaterEntity" , cascade = CascadeType.ALL)
    private List<ShowEntity> showEntityList = new ArrayList<>();


}
