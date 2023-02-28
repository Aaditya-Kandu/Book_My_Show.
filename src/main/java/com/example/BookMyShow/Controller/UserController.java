package com.example.BookMyShow.Controller;

import com.example.BookMyShow.EntryDTOs.UserEntryDTO;
import com.example.BookMyShow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add_user")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDTO userEntryDTO){

        try {
            String response = userService.addUser(userEntryDTO);

            return new ResponseEntity<>(response , HttpStatus.CREATED);
        }
        catch (Exception e){
            String result = "User could not be added";

            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }


    }
}