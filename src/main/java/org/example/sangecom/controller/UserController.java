package org.example.sangecom.controller;

import lombok.RequiredArgsConstructor;
import org.example.sangecom.dto.request.UserDto;
import org.example.sangecom.entity.User;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final org.example.sangecom.service.UserService userServiceImpl;
    @PostMapping("/save")
    User createUser(@RequestBody UserDto user) {

        return userServiceImpl.saveUser(user);
    }
    @GetMapping("/")
public String home() {
        return "/index";
    }

}
