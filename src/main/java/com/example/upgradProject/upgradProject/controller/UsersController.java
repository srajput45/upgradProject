package com.example.upgradProject.upgradProject.controller;

import com.example.upgradProject.upgradProject.model.Users;
import com.example.upgradProject.upgradProject.repository.UsersRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class UsersController {
    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/users")
    Collection<Users> users(){
        return usersRepository.findAll();
    }
}
