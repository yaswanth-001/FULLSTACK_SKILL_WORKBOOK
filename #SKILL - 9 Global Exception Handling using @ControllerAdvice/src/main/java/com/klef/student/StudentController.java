package com.klef.student;

import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable String id) {

        int studentId;

        try {
            studentId = Integer.parseInt(id);
        } catch (Exception e) {
            throw new InvalidInputException("Invalid ID format. Please enter a number.");
        }

        if (studentId != 1) {
            throw new StudentNotFoundException("Student not found with ID: " + studentId);
        }

        return new Student(1, "Sai");
    }
}