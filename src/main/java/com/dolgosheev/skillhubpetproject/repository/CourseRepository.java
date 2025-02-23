package com.dolgosheev.skillhubpetproject.repository;

import com.dolgosheev.skillhubpetproject.model.Course;
import com.dolgosheev.skillhubpetproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByAuthor(User author);
    List<Course> findByAuthorId(Long authorId);
    List<Course> findByTitleContainingIgnoreCase(String title);
    List<Course> findAllByOrderByTitleAsc();
}