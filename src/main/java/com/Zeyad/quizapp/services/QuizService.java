package com.Zeyad.quizapp.services;

import com.Zeyad.quizapp.dao.QuestionDao;
import com.Zeyad.quizapp.dao.QuizDao;
import com.Zeyad.quizapp.models.QuizModel;
import com.Zeyad.quizapp.models.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title){

        List<QuestionModel> question = questionDao.findRandomlyQuestionByCategory(category, numQ);
        QuizModel quiz = new QuizModel();

        quiz.setTitle(title);
        quiz.setQuestions(question);

        quizDao.save(quiz);

        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuizModel>> getAllQuiz(){
        return new ResponseEntity<>(quizDao.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<QuizModel> getQuiz(String title){
        return new ResponseEntity<>(quizDao.findQuizModelByTitle(title),HttpStatus.OK);
    }
}
