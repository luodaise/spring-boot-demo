package com.djb.springbootdemo.web;


import com.djb.springbootdemo.domain.Book;
import com.djb.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {


    @Autowired
    private BookService bookService;


    //获取书单列表
    @GetMapping("/books")
    public String list(Model model){
        List<Book> books= bookService.findAll();
        model.addAttribute("books",books);
        return "books";
    }

    //书单详情
    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model){

        Book book = bookService.findOne(id);
        if(book ==null){
            book = new Book();
        }
        model.addAttribute("book",book);
        return "book";
    }


    //跳转input页面
    @GetMapping("/books/input")
    public String inputPage(Model model){
        model.addAttribute("book",new Book());
        return "input";
    }

    //提交书单信息
    @PostMapping("/books")
    public String post(Book book, final RedirectAttributes attributes){
        Book book1 = bookService.save(book);
        if(book1 != null){
            attributes.addFlashAttribute("message","《"+ book1.getName() +"》信息提交成功");
        }
        return "redirect:/books";
    }


    //跳转更新页面
    @GetMapping("/books/{id}/input")
    public String inputEditPage(@PathVariable long id ,Model model){
        Book book = bookService.findOne(id);
        model.addAttribute("book",book);
        return "input";
    }
}
