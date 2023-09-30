package com.Zeyad.quizapp.dao;

import com.Zeyad.quizapp.models.QuizModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<QuizModel, Integer> {
    public QuizModel findQuizModelByTitle (String title);
}
