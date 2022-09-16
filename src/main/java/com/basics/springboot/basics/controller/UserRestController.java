package com.basics.springboot.basics.controller;

import com.basics.springboot.basics.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    @GetMapping("/")
    List<User> getUsers(){
return new ArrayList<>();
    }
    @PostMapping("/")
    ResponseEntity<User> postUser(@RequestBody User user){
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }
//    Pagination
    @GetMapping("/pag")
    List<User> getUserPagination(@RequestParam int page, @RequestParam int size){
        return userRepository.findAll(PageRequest.of(page, size))
    }
}
