package com.example.BookMyShow.Entities;

import com.example.BookMyShow.Enums.Languages;
import com.example.BookMyShow.Enums.MovieTypes;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Data
//@Getter
//@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(unique = true, nullable = false)
    private String movieName;

    private double rating;

    private int duration;

    @Enumerated(value = EnumType.STRING)
    private Languages languages;

    @Enumerated(value = EnumType.STRING)
    private MovieTypes movieTypes;

    // It is parent wrt the show Entity
    // Let us mapping with child show entity

    @OneToMany(mappedBy = "movieEntity" , cascade = CascadeType.ALL)
    private List<ShowEntity> showEntityList = new ArrayList<>();



}
