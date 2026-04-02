package com.klef.course;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private List<Course> courseList = new ArrayList<>();

    // Add
    public Course addCourse(Course c) {
        courseList.add(c);
        return c;
    }

    // Get All
    public List<Course> getAllCourses() {
        return courseList;
    }

    // Get by ID
    public Course getCourse(int id) {
        return courseList.stream()
                .filter(c -> c.getCourseId() == id)
                .findFirst().orElse(null);
    }

    // Update
    public Course updateCourse(int id, Course newCourse) {
        Course c = getCourse(id);
        if (c != null) {
            c.setTitle(newCourse.getTitle());
            c.setDuration(newCourse.getDuration());
            c.setFee(newCourse.getFee());
        }
        return c;
    }

    // Delete
    public boolean deleteCourse(int id) {
        return courseList.removeIf(c -> c.getCourseId() == id);
    }

    // Search by title
    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course c : courseList) {
            if (c.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(c);
            }
        }
        return result;
    }
}