package com.example.upgradProject.upgradProject.controller;

import com.example.upgradProject.upgradProject.model.Users;
import com.example.upgradProject.upgradProject.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users")
    Collection<Users> users(){
        return usersRepository.findAll();
    }

    @GetMapping("/users/{id}")
    ResponseEntity<?> getCategory(@PathVariable Long id){
        Optional<Users> category = usersRepository.findById(id);
        return category.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/users")
    ResponseEntity<Users> createCategory(@Validated @RequestBody Users users) throws URISyntaxException {
        Users result = usersRepository.save(users);
        return ResponseEntity.created(new URI("/api/users" + result.getId())).body(result);
    }
    @PutMapping("/users/{id}")
    ResponseEntity<Users> updateCategory(@Validated @RequestBody Users users){
        Users result = usersRepository.save(users);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/users/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id){
        usersRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
