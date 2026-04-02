package com.klef.library;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    // 1 Welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library";
    }

    // 2 Count
    @GetMapping("/count")
    public int count() {
        return 100;
    }

    // 3 Price
    @GetMapping("/price")
    public double price() {
        return 499.99;
    }

    // 4 List of books
    @GetMapping("/books")
    public List<String> books() {
        return Arrays.asList("Java", "Spring", "Python");
    }

    // 5 PathVariable
    @GetMapping("/books/{id}")
    public String getBook(@PathVariable int id) {
        return "Book details for ID: " + id;
    }

    // 6 RequestParam
    @GetMapping("/search")
    public String search(@RequestParam String title) {
        return "Searching for: " + title;
    }

    // 7 Author
    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books by " + name;
    }

    // 8 POST add book
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully";
    }

    // 9 View books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}