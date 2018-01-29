package com.djb.springbootdemo.web;


import com.djb.springbootdemo.domain.Book;
import com.djb.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookApp {

    @Autowired
    private BookService bookservice;
    @GetMapping("/books")
    public List<Book> getAll(){
        return bookservice.findAll();
    }
    /**
     * 新增的时候字段太多可以用实体来传
     * @PostMapping("books")
     * public Book post(Book book){
     *     return bookService.save(book);
     * }
     */
    @PostMapping("/books")
    public Book post(@RequestParam String name,
                     @RequestParam String author,
                     @RequestParam String description,
                     @RequestParam int status
                     ){
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);

        return bookservice.save(book);
    }

    @GetMapping("/books/{id}")
    public  Book getOne(@PathVariable long id){
        return bookservice.findOne(id);
    }


    @PutMapping("/books")
    public Book update(@RequestParam long id,
                       @RequestParam String name,
                       @RequestParam String author,
                       @RequestParam String description,
                       @RequestParam int status){
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);

        return bookservice.save(book);

    }

    @DeleteMapping("/books/{id}")
    public void deleteOne(@PathVariable long id){
        bookservice.delete(id);
    }

    @PostMapping("/books/by")
//    public List<Book> findBy(@RequestParam String author){
//        return bookservice.findByAuthor(author);
//    }
//    public List<Book> findBy(@RequestParam String author,@RequestParam int status){
//        return bookservice.findByAuthorAndStatus(author,status);
//    }
//    public List<Book> findBy(@RequestParam String description){
//        return bookservice.findByDescriptionContains(description);
//    }

    public List<Book> findBy(@RequestParam int len){
        return bookservice.findByJPQL(len);
    }
}
