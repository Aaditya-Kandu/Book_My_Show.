package com.example.BookMyShow.EntryDTOs;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
import lombok.Data;

@Data

public class UserEntryDTO {

    private String name;

    private int age;

    private String mobileNO;

    private String address;

    private String email;
}
