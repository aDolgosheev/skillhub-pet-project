package com.dolgosheev.skillhubpetproject.controller;

import com.dolgosheev.skillhubpetproject.model.Course;
import com.dolgosheev.skillhubpetproject.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FrontendController {

    private final CourseService courseService;

    public FrontendController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "index";
    }

    @GetMapping("/courses")
    public String courses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/courses/{id}")
    public String courseDetails(@PathVariable("id") Long id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "course-details";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
