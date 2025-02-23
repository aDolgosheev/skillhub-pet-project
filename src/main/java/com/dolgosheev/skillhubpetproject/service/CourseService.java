package com.dolgosheev.skillhubpetproject.service;

import com.dolgosheev.skillhubpetproject.model.Course;
import com.dolgosheev.skillhubpetproject.model.User;
import com.dolgosheev.skillhubpetproject.repository.CourseRepository;
import com.dolgosheev.skillhubpetproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseService(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public Course createCourse(Long authorId, Course course) {
        Optional<User> authorOpt = userRepository.findById(authorId);
        if (authorOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        course.setAuthor(authorOpt.get());
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }
}