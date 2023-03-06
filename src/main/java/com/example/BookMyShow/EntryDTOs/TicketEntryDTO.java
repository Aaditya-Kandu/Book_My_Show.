package com.example.BookMyShow.EntryDTOs;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketEntryDTO {

    private int showId;

    private List<String> requestedSeat = new ArrayList<>();

    private int useId;


}
