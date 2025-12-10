package com.example.BookStore.repository;

import com.example.BookStore.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.assertj.core.api.Assertions.assertThat;


public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testFindBookByBookId() {
        Book book = new Book("01", "Test Book", "100", "Author", "Description");
        bookRepository.save(book);

        Book foundBook = bookRepository.findBookByBookId("01");
        assertThat(foundBook).isNotNull();
        assertThat(foundBook.name()).isEqualTo("Test Book");
    }

    @Test
    void testUpdateBookNameByBookId() {
        Book book = new Book("02", "Old Name", "100", "Author", "Description");
        bookRepository.save(book);

        bookRepository.updateBookNameByBookId("02", "New Name");

        Book updatedBook = bookRepository.findBookByBookId("02");
        assertThat(updatedBook).isNotNull();
        assertThat(updatedBook.name()).isEqualTo("New Name");
    }
}
