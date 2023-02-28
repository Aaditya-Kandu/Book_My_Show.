package com.example.BookMyShow.Services;

import com.example.BookMyShow.Convertors.UserConvertor;
import com.example.BookMyShow.Entities.UserEntity;
import com.example.BookMyShow.EntryDTOs.UserEntryDTO;
import com.example.BookMyShow.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDTO userEntryDTO) throws Exception{

       UserEntity userEntity = UserConvertor.convertDTOtoEntity(userEntryDTO);

       userRepository.save(userEntity);

       return "User Added Successfully";

    }
}
