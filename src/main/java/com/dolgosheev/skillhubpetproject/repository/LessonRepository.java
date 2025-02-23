package com.dolgosheev.skillhubpetproject.repository;

import com.dolgosheev.skillhubpetproject.model.Course;
import com.dolgosheev.skillhubpetproject.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByCourse(Course course);
    List<Lesson> findByCourseId(Long courseId);
}
