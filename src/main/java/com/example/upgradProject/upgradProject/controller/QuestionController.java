package com.example.upgradProject.upgradProject.controller;
import com.example.upgradProject.upgradProject.model.Question;
import com.example.upgradProject.upgradProject.repository.QuestionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

public class QuestionController {
    private QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository) {
        super();
        this.questionRepository = questionRepository;
    }


    @GetMapping("/question/all")
    Collection<Question> questions(){
        return questionRepository.findAll();
    }

    @GetMapping("/question/{id}")
    ResponseEntity<?> getQuestion(@PathVariable Long id){
        Optional<Question> question = questionRepository.findById(id);
        return question.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/question/delete/{id}")
    ResponseEntity<?> deleteQuestion(@PathVariable Long id){
        questionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/question/create")
    ResponseEntity<Question> createQuestion(@Valid @RequestBody Question question) throws URISyntaxException {
        Question result= questionRepository.save(question);
        return ResponseEntity.created(new URI("/api/question" + result.getUuid())).body(result);
    }

    @PutMapping("/question/edit/{id}")
    ResponseEntity<Question> updateQuestion(@Valid @RequestBody Question question){
        Question result= questionRepository.save(question);
        return ResponseEntity.ok().body(result);
    }
}
