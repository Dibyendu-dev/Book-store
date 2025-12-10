package com.example.BookStore.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookStore.dto.BookDTO;
import com.example.BookStore.service.BookService;

@RestController
@RequestMapping("/bookstore")
public class BookController {

    BookService bookservice;

    public BookController(BookService bookService){
        this.bookservice=bookService;
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDTO> getBook(@PathVariable String bookId){
       BookDTO bookDTO = bookservice.getBook(bookId);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        List<BookDTO> booksDTOList = bookservice.getAllBooks(); 
        return new ResponseEntity<>(booksDTOList, HttpStatus.OK);
    }

    @PostMapping("/")
     public ResponseEntity<BookDTO> createBooks(@RequestBody BookDTO bookDTO){
        BookDTO bookDTO1 = bookservice.createBook(bookDTO);
        return new ResponseEntity<>(bookDTO1, HttpStatus.OK);
     }

     @PutMapping("/")
      public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO bookDTO){
        BookDTO bookDTO1 = bookservice.updateBookName(bookDTO);
        return new ResponseEntity<>(bookDTO1, HttpStatus.OK);
     }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable String bookId){
        bookservice.deleteBookByBookId(bookId);
        return new ResponseEntity<>("Book deleted successfully" , HttpStatus.OK);
    }
}
