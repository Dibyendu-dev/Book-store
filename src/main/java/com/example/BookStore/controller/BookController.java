package com.example.BookStore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore")
public class BookController {

    @GetMapping("/{bookId}")
    public ResponseEntity<String> getBook(@PathVariable String bookId){
        return new ResponseEntity<>("Book Found" + bookId, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<String>> getAllBooks(){
        List<String> books = new ArrayList<>();
        books.add("java");
        books.add("python");
        books.add("javaScript");
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/")
     public ResponseEntity<String> createBooks(String book){
        return new ResponseEntity<>("books created succesfully", HttpStatus.OK);
     }

     @PutMapping("/")
      public ResponseEntity<String> updateBook(String book){
        return new ResponseEntity<>("books updated succesfully", HttpStatus.OK);
     }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable String bookId){
        return new ResponseEntity<>("Book deleted successfully" , HttpStatus.OK);
    }
}
