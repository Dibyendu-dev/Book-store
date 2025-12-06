package com.example.BookStore.mapper;

import com.example.BookStore.dto.BookDTO;
import com.example.BookStore.entity.Book;

public class BookMapper {

    public static BookDTO toDTO(Book book){
        BookDTO bookDTO = new BookDTO(book.bookId(), book.name(), book.price(),
        book.author(),book.description());
        return bookDTO;
    }

    public static Book toEntity(BookDTO bookDTO){
        Book book= new Book(bookDTO.bookId(), bookDTO.name(), bookDTO.price(),
        bookDTO.author(),bookDTO.description());
        return book;
    }
}
