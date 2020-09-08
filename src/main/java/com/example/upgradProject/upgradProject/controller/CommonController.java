package com.example.upgradProject.upgradProject.controller;

import com.example.upgradProject.upgradProject.model.Users;
import com.example.upgradProject.upgradProject.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CommonController {
    private final UsersRepository usersRepository;

    public CommonController(UsersRepository usersRepository) {
        super();
        this.usersRepository = usersRepository;
    }

    @GetMapping("/userprofile/{id}")
    ResponseEntity<?> getUsers(@PathVariable Long id){
        Optional<Users> users = usersRepository.findById(id);
        return users.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
