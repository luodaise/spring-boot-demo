package com.djb.springbootdemo.service;

import com.djb.springbootdemo.domain.Book;
import com.djb.springbootdemo.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public Book findOne(long id){
        return bookRepository.findOne(id);
    }

    public  void delete(long id){
       bookRepository.delete(id);
    }

    public List<Book> findByAuthor(String author){
      return bookRepository.findByAuthor(author);
    }


    public List<Book> findByAuthorAndStatus(String author,int status){
        return bookRepository.findByAuthorAndAndStatus(author,status);
    }

    public List<Book> findByDescriptionContains(String description){
        return bookRepository.findByDescriptionContains(description);
    }

    public  List<Book> findByJPQL(int len){
        return bookRepository.findByJPQL(len);
    }
}
