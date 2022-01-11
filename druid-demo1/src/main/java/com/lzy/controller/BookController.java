package com.lzy.controller;


import com.lzy.pojo.Book;
import com.lzy.service.impl.BookServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzy
 * @since 2022-01-04
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookServiceImpl bookServiceImpl;

    //@GetMapping("/all")
    //@ApiOperation("API--获取所有图书信息")
    @RequestMapping("/all")
    public List<Book> getAll(){
        List<Book> list1=bookServiceImpl.list();
        list1.forEach(System.out::println);
        return list1;
    }


    //@GetMapping("/bid/{id}")
    //@ApiOperation("API--通过id获取图书信息")
    @RequestMapping("/bid/{id}")
    public Book getById(@PathVariable("id")Long id){
        Book B2= bookServiceImpl.getById(id);
        System.out.println(B2);
        return B2;
    }


    // 这里的book1会被Swagger自动识别
    //@PostMapping("/add")
    //@ApiOperation("用户接口 - 添加图书信息")
    @RequestMapping("/add")
    //public Book addBook(@RequestBody Book book1){
    public Book addBook(Book book1){
        System.out.println("come in1 ..");
        //Book book1=new Book();
        book1.setBname("postgresql");
        book1.setBcount(12L);
        book1.setBauthor("JK.kithy");
        bookServiceImpl.addBookToSlave(book1);
        System.out.println("come in2 ..");
        return book1;
    }

}

