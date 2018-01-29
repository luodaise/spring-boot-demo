package com.djb.springbootdemo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findByAuthor(String author);

    List<Book> findByAuthorAndAndStatus(String author,int status);

    List<Book> findByDescriptionContains(String description);


    @Query("select b from Book b where length(b.name) > ?1 ")
    List<Book> findByJPQL(int len);
}
