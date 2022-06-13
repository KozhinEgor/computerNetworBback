package com.back.computernetworkback.controller;

import com.back.computernetworkback.ModelMapper.ModelUser;
import com.back.computernetworkback.dto.UserDto;
import com.back.computernetworkback.enity.Otdel;
import com.back.computernetworkback.enity.User;
import com.back.computernetworkback.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelUser modelUser;

    @PostMapping(value = "/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody UserDto userDto){
        if( userRepository.findUserByEmail(userDto.getEmail()) != null){
            return new ResponseEntity<>(modelUser.toUserDto(userRepository.findUserByEmail(userDto.getEmail())), HttpStatus.OK);
        }
        else{
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No users");
        }

    }

    @GetMapping("/findAllUsers")
    public List<UserDto> allUsers(){

        return modelUser.toListUserDto(userRepository.findAll());
    }

    @PostMapping("/findUserByOtdel")
    public List<User> findUserByOtdel(@RequestBody Otdel otdel){
        List<User> users = userRepository.findAllByOtdel(otdel);
        return users;
    }

    @GetMapping("/findUser")
    public List<User> findUser(){
        List<User> users = userRepository.findAll();
        return users;
    }

    @PostMapping("/findCountUserByOtdel")
    public Integer findCountUserByOtdel(@RequestBody Otdel otdel){
        return userRepository.findAllByOtdel(otdel).size();
    }

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @PostMapping("/createUser")
    public List<User> createUser(@RequestBody Otdel otdel){
        User user = new User();
        user.setDolzhnost("");
        user.setEmail("");
        user.setFio("Новый пользователь");
        user.setOtdel(otdel);
        user.setPassword("");
        user.setRole("");
        user.setId(null);
        userRepository.save(user);
        return userRepository.findAllByOtdel(otdel);
    }

}
