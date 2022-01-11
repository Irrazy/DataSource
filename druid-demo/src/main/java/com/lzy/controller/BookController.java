package com.lzy.controller;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.lzy.pojo.Book;
import com.lzy.serviceImpl.BookServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzy
 * @since 2021-12-30
 */

@RestController
@RequestMapping("/book")
@Api(value = "图书接口功能",tags = "BookController")
public class BookController extends ApiController {
    @Resource
    BookServiceImpl bookServiceImpl;

    //忽略这个api
    @Operation(hidden = true)
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //@Operation(summary = "API--获取所有图书信息")
    /*
    @Operation和@ApiOperation这两个注解都可以注解接口信息
    but:1.使用@Operation，在Swagger3Config里面 用.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        2.使用@ApiOperation，在Swagger3Config里面 用(ApiOperation.class)，两个参数不一样，两边文件要一致
     */

    @GetMapping("/all")
    @ApiOperation("API--获取所有图书信息")
    public List<Book> getAll(){
       List<Book> list1=bookServiceImpl.list();
        list1.forEach(System.out::println);
        return list1;
    }


    @GetMapping ("/bid/{id}")
    @ApiOperation("API--通过id获取图书信息")
    public Book getById(@PathVariable("id")Long id){
       Book B2= bookServiceImpl.getById(id);
        System.out.println(B2);
        return B2;
    }


    // 这里的book1会被Swagger自动识别
    @PostMapping ("/add")
    @ApiOperation("用户接口 - 添加图书信息")
    public Book addBook(@RequestBody Book book1){
        //Book book1=new Book();
        book1.setBname("postgresql");
        book1.setBcount(12L);
        book1.setBauthor("JK.kithy");
       bookServiceImpl.save(book1);
        return book1;
    }


}

