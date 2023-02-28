package com.example.BookMyShow.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theater")
@Data
@NoArgsConstructor
public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String location;

    //mapping in parent class.

    @OneToMany(mappedBy = "theaterEntity" , cascade = CascadeType.ALL)
    private List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

    // It is parent wrt the show Entity.

    @OneToMany(mappedBy = "theaterEntity" , cascade = CascadeType.ALL)
    private List<ShowEntity> showEntityList = new ArrayList<>();


}
