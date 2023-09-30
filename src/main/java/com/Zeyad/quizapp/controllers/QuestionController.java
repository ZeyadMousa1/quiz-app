package com.Zeyad.quizapp.controllers;

import com.Zeyad.quizapp.models.QuestionModel;
import com.Zeyad.quizapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<QuestionModel>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<QuestionModel>> getQuestionsByCategory(@PathVariable String category ){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionModel question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping("{id}")
    public String DeleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }

}
