package com.example.BookMyShow.Convertors;


import com.example.BookMyShow.Entities.UserEntity;
import com.example.BookMyShow.EntryDTOs.UserEntryDTO;

public class UserConvertor {

    public static UserEntity convertDTOtoEntity(UserEntryDTO userEntryDTO){


        UserEntity userEntity = UserEntity.builder().age(userEntryDTO.getAge()).name(userEntryDTO.getName()).email(userEntryDTO.getEmail())
                .address(userEntryDTO.getAddress()).mobileNO(userEntryDTO.getMobileNO()).build();

        return userEntity;

    }
}
