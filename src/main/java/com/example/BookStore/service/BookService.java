package com.example.BookStore.service;

import java.util.List;

import com.example.BookStore.dto.BookDTO;

public interface BookService {
    
    public BookDTO getBook(String bookId);

    public List<BookDTO> getAllBooks();

    public BookDTO createBook(BookDTO bookDTO);
    
    public BookDTO updateBookName(BookDTO bookDTO);

    public void deleteBookByBookId(String bookId);


}
