package com.example.BookMyShow.Controller;

import com.example.BookMyShow.EntryDTOs.TheaterEntryDTO;
import com.example.BookMyShow.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/add_theater")
    public String addTheater(@RequestBody()TheaterEntryDTO theaterEntryDTO){
        return "";

    }
}
