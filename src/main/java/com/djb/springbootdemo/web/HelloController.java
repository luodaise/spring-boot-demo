package com.djb.springbootdemo.web;

import com.djb.springbootdemo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
//@Controller
@RequestMapping("/api/v2")
public class HelloController {




    //@RequestMapping(value = "/say",method = RequestMethod.GET)
    @PostMapping("/say")
    public String hello(){
        return"hello spring ";
    }


    @GetMapping("/books")
    //@ResponseBody
    public Object getAll(@RequestParam("page") int page ,@RequestParam(value = "size",defaultValue = "10") int size){
        Map<String,Object> book = new HashMap<>();
        book.put("name","互联网看世界");
        book.put("isbn","1323544656");
        book.put("author", "张兰思");
        Map<String,Object> book2 = new HashMap<>();
        book2.put("name","互联网看世界2");
        book2.put("isbn","13235446562");
        book2.put("author", "张兰思2");

        List<Map> contents = new ArrayList<>();
        contents.add(book);
        contents.add(book2);

        Map<String,Object> pagemap = new HashMap<>();
        pagemap.put("page",page);
        pagemap.put("size",size);
        pagemap.put("content",contents);
        return pagemap;
    }

    @GetMapping("/books/{id}")
    public Object getOne(@PathVariable long id){
        return null;
    }


    @PostMapping("/books")
    public Object post(@RequestParam("name") String name,@RequestParam("author") String author,@RequestParam("isbn") String isbn){
       Map<String,Object> book = new HashMap<String,Object>();
       book.put("name",name);
       book.put("author",author);
       book.put("isbn",isbn);
       return book;
    }
}