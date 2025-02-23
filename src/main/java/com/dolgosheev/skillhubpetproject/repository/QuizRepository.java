package com.dolgosheev.skillhubpetproject.repository;

import com.dolgosheev.skillhubpetproject.model.Course;
import com.dolgosheev.skillhubpetproject.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByCourse(Course course);
    List<Quiz> findByCourseId(Long courseId);
}
