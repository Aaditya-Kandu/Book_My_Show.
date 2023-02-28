package com.example.BookMyShow.Entities;

import com.example.BookMyShow.Enums.ShowType;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
@Data
//@Getter
//@Setter
@NoArgsConstructor
public class ShowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   // @Timestamp()
    private LocalDate showDate;

   // @Timestamp
    private LocalTime showTime;

    @Enumerated(value = EnumType.STRING)
    private ShowType showType;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    // It is child wrt the Movie entity
    //let us mapping

    @ManyToOne
    @JoinColumn
    private MovieEntity movieEntity;

    // show is child wrt the Theater Entity

    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;

    // show entity is parent wrt the ticket entity

    @OneToMany(mappedBy = "showEntity" , cascade = CascadeType.ALL)
    private List<TicketEntity> listOfBookedTickets = new ArrayList<>();

    // show entity is parent wrt the show seat entity

    @OneToMany(mappedBy = "showEntity", cascade = CascadeType.ALL)
    private List<ShowSeatEntity> listOfShowSeat = new ArrayList<>();




}
