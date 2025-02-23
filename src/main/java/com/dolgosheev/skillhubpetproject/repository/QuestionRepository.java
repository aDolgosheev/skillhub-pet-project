package com.dolgosheev.skillhubpetproject.repository;

import com.dolgosheev.skillhubpetproject.model.Question;
import com.dolgosheev.skillhubpetproject.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuiz(Quiz quiz);
    List<Question> findByQuizId(Long quizId);
}
