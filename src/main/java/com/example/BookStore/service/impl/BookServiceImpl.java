package com.example.BookStore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BookStore.dto.BookDTO;
import com.example.BookStore.entity.Book;
import com.example.BookStore.mapper.BookMapper;
import com.example.BookStore.repository.BookRepository;
import com.example.BookStore.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository= bookRepository;
    }

    @Override
    public BookDTO getBook(String bookId) {
      Book book =  bookRepository.findBookByBookId(bookId);
      BookDTO bookDTO = BookMapper.toDTO(book);

      return bookDTO;
    }

    @Override
    public List<BookDTO> getAllBooks() {
      List<Book> books = bookRepository.findAll();
      List<BookDTO> bookDTOList = new ArrayList<>();
      for(Book book: books){
        bookDTOList.add(BookMapper.toDTO(book));
      }
      return bookDTOList;
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
       Book book =bookRepository.insert(BookMapper.toEntity(bookDTO));
       return BookMapper.toDTO(book);
    }

    @Override
    public BookDTO updateBookName(BookDTO bookDTO) {
       bookRepository.updateBookNameByBookId(bookDTO.bookId(),bookDTO.name());
       Book book = bookRepository.findBookByBookId(bookDTO.bookId());
       return BookMapper.toDTO(book);
    }

    @Override
    public void deleteBookByBookId(String bookId) {
      bookRepository.deleteBookByBookId(bookId);
    }

}
