package com.back.computernetworkback.ModelMapper;

import com.back.computernetworkback.dto.UserDto;
import com.back.computernetworkback.enity.User;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;


import java.lang.reflect.Type;

import java.util.List;

@Service
public class ModelUser {
    ModelMapper modelMapper = new ModelMapper();
    private final Type typeUserDTO = new TypeToken<UserDto>(){}.getType();
    private final Type typelistUserDTO = new TypeToken<List<UserDto>>(){}.getType();
    private final Type typeUser = new TypeToken<User>(){}.getType();
    private final Type typelistUser = new TypeToken<List<User>>(){}.getType();

    public UserDto toUserDto(User user){
        return modelMapper.map(user,typeUserDTO);
    }
    public List<UserDto> toListUserDto(List<User> users){
        return modelMapper.map(users, typelistUserDTO);
    }

    public User toUser(UserDto user){
        return modelMapper.map(user,typeUserDTO);
    }
    public List<User> toListUser(List<UserDto> users){
        return modelMapper.map(users, typelistUser);
    }
}
