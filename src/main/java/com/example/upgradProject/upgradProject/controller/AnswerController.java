package com.example.upgradProject.upgradProject.controller;
import com.example.upgradProject.upgradProject.model.Answer;
import com.example.upgradProject.upgradProject.repository.AnswerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AnswerController {
    private  AnswerRepository answerRepository;

    public AnswerController(AnswerRepository answerRepository) {
        super();
        this.answerRepository = answerRepository;
    }

    @GetMapping("/answer")
    Collection<Answer> answers(){
        return answerRepository.findAll();
    }

    @GetMapping("/answer/{id}")
    ResponseEntity<?> getAnswer(@PathVariable Long id){
        Optional<Answer> answer = answerRepository.findById(id);
        return answer.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/answer/delete/{id}")
    ResponseEntity<?> deleteAnswer(@PathVariable Long id){
        answerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/answer")
    ResponseEntity<Answer> createAnswer(@Valid @RequestBody Answer answer) throws URISyntaxException {
        Answer result= answerRepository.save(answer);
        return ResponseEntity.created(new URI("/api/answer" + result.getUuid())).body(result);
    }

    @PutMapping("/answer/edit/{id}")
    ResponseEntity<Answer> updateAnswer(@Valid @RequestBody Answer answer){
        Answer result= answerRepository.save(answer);
        return ResponseEntity.ok().body(result);
    }
}
