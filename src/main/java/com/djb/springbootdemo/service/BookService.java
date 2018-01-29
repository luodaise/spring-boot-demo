package com.djb.springbootdemo.service;

import com.djb.springbootdemo.domain.Book;
import com.djb.springbootdemo.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

//    public List<Book> findByAuthor(String author){
//      return bookRepository.findByAuthor(author);
//    }
//
//
//    public List<Book> findByAuthorAndStatus(String author,int status){
//        return bookRepository.findByAuthorAndAndStatus(author,status);
//    }
//
//    public List<Book> findByDescriptionContains(String description){
//        return bookRepository.findByDescriptionContains(description);
//    }

   public  List<Book> findByJPQL(int len){
        return bookRepository.findByJPQL(len);
    }


    @Transactional
    public int updateByJPQL(int status ,long id){
        return bookRepository.updateByJPQL(status,id);
    }


    public int deleteByJPQL(long id){
        return bookRepository.deleteByJPQL(id);
    }


    /**测试事物*/
    @Transactional
    public int deleteAndUpdate(long id, int status, long uid){
        int dcount = bookRepository.deleteByJPQL(id);
        int ucount = bookRepository.updateByJPQL(status,uid);
        return dcount+ucount;
    }
}
