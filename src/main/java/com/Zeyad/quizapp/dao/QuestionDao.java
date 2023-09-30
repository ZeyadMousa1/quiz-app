package com.Zeyad.quizapp.dao;

import com.Zeyad.quizapp.models.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<QuestionModel, Integer> {
    List<QuestionModel> findByCategory(String category);

    @Query(value = "SELECT * FROM question_model AS q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<QuestionModel> findRandomlyQuestionByCategory(String category, int numQ);
}
