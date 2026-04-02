package com.klef.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    // CREATE
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course c) {
        service.addCourse(c);
        return new ResponseEntity<>("Course Added", HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {
        Course c = service.getCourse(id);
        if (c == null)
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course c) {
        Course updated = service.updateCourse(id, c);
        if (updated == null)
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Course Updated", HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        boolean deleted = service.deleteCourse(id);
        if (!deleted)
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Course Deleted", HttpStatus.OK);
    }

    // SEARCH
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> search(@PathVariable String title) {
        return new ResponseEntity<>(service.searchByTitle(title), HttpStatus.OK);
    }
}