package com.Zeyad.quizapp.controllers;

import com.Zeyad.quizapp.models.QuizModel;
import com.Zeyad.quizapp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(
            @RequestParam String category, @RequestParam int numQ, @RequestParam String title)
    {
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<QuizModel>> getAllQuiz(){
        return quizService.getAllQuiz();
    }

    @GetMapping("/{title}")
    public ResponseEntity<QuizModel> getQuiz(@PathVariable String title){
        return quizService.getQuiz(title);
    }
}
