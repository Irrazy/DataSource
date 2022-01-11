package com.lzy.controller;

import com.github.pagehelper.PageInfo;
import com.lzy.pojo.Book;
import com.lzy.serviceImpl.BookServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: druid-multiple-tk
 * @description: controller
 * @author: 作者
 * @create: 2022-01-05 16:15
 */
@RestController
@RequestMapping("/book")
@Api(value = "图书信息接口",tags = "BookController")
public class BookController{
    @Resource
    private BookServiceImpl bookServiceImpl;

    @ApiOperation("API--分页展示")
    //分页---只做后端测试，没有前端页面展示
    @GetMapping("/page")
    public List<Book> getUsersByPage(@RequestParam(value = "pageNum",defaultValue = "2")Integer pageNum, Model model){
        // 首页右侧分类
        PageInfo<Book> typePageInfo = bookServiceImpl.getUsersByPage(pageNum,3);
        model.addAttribute("pageinfo",typePageInfo);//将pageinfo储存到模型中并返回到web页面
        List<Book> list1 =  typePageInfo.getList();
        return list1;
    }

    //忽略这个Api
    @Operation(hidden = true)
    /********/
    //分页---加上前端页面展示
    @GetMapping("/page2")
    public String getUsersByPage2(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum, Model model){

        // 首页右侧分类
        PageInfo<Book> typePageInfo = bookServiceImpl.getUsersByPage(pageNum,2);
        model.addAttribute("pageinfo",typePageInfo);
        return "index"; //--转换成jsp

    }

    @ApiOperation("API--获取所有图书信息")
    @GetMapping("/selectAll")
    public List<Book> selectAll(){
        List<Book> list1=bookServiceImpl.selectAll();
        list1.forEach(System.out::println);
        return list1;
    }

    @ApiOperation("API--通过id查找图书")
    @GetMapping("/findId")
    public Book findById(){
        Book book=bookServiceImpl.findById(25L);
        System.out.println(book);
        return  book;
    }

    @ApiOperation("API--添加图书")
    // 这里的book会被Swagger自动识别，所以在参数前面添加swagger的注解@RequestBody
    @PostMapping("/insert")
    public String insert(@RequestBody Book book){
        //user.setId(null);
        book.setBname("jsp");
        book.setBcount(7L);
        book.setBauthor("Mr Liu");
        int a=bookServiceImpl.insertSelective(book);
        //int a=userServiceImpl.insert(user);
        System.out.println(a); //成功的话a的值是1
        return  "add book sucessful";
    }

    @ApiOperation("API--通过id更新图书信息")
    @PutMapping("/updateByPrimaryKey/{id}")
    public String updateByPrimaryKey(@PathVariable("id")Long id){
        Book book=bookServiceImpl.findById(id);
        book.setBname("进阶算法");
        book.setBcount(18L);
        book.setBauthor("Miss chen");
        int a = bookServiceImpl.updateByPrimaryKey(book);
        System.out.println(a);
        if(a==1){
            return  "update sucessful";
        }else{
            return  "update erro";
        }
    }

    @ApiOperation("API--通过id删除图书信息")
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")Long id){
        int a = bookServiceImpl.delete(id);
        System.out.println(a);
        if(a==1){
            return  "sucessful";
        }else{
            return  "erro";
        }

    }
}
