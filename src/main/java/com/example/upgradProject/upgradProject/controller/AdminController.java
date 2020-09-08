package com.example.upgradProject.upgradProject.controller;

import com.example.upgradProject.upgradProject.repository.UsersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminController {

    private final UsersRepository usersRepository;

    public AdminController(UsersRepository usersRepository) {
        super();
        this.usersRepository = usersRepository;
    }

    @DeleteMapping("admin/user/{id}")
    ResponseEntity<?> deleteUsers(@PathVariable Long id){
        usersRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
