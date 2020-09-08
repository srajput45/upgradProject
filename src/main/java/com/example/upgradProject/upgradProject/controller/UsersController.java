package com.example.upgradProject.upgradProject.controller;

import com.example.upgradProject.upgradProject.model.Users;
import com.example.upgradProject.upgradProject.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsersController {
    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        super();
        this.usersRepository = usersRepository;
    }

    @PostMapping("/users")
    ResponseEntity<Users> createusers(@Valid @RequestBody Users users) throws URISyntaxException {
        Users result= usersRepository.save(users);
        return ResponseEntity.created(new URI("/api/users" + result.getUuid())).body(result);
    }

    @PutMapping("/users/{id}")
    ResponseEntity<Users> updateusers(@Valid @RequestBody Users users){
        Users result= usersRepository.save(users);
        return ResponseEntity.ok().body(result);
    }

}
