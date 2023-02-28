package com.example.BookMyShow.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(unique = true)
    private String mobileNO;

    private String address;

    @Column(unique = true)
    private String email;


    // user is parent wrt the ticket entity

    @OneToMany(mappedBy = "userEntity" , cascade = CascadeType.ALL)
    private List<TicketEntity> bookedTickets = new ArrayList<>();


}
