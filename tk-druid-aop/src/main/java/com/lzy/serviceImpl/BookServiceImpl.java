package com.lzy.serviceImpl;

//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;

import com.lzy.annotation.DataSource;
import com.lzy.mapper.BookMapper;
import com.lzy.pojo.Book;
import com.lzy.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: druid-multiple-tk
 * @description: impl
 * @author: 作者
 * @create: 2022-01-05 15:57
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;
    @Override
    public List<Book> selectAll() {
        return bookMapper.selectAll();
    }

    @Override
    public Book findById(Long id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    //增加一个
    @Override
    //用数据源注解切换到从数据库
    @DataSource("DBS2_KEY") //@DataSource("db2") 直接用value值也可以
    public int insertSelective(Book book) {
        //用insertSelective不会给没有赋值的字段插入null值，有些字段有默认值就要用这个方法
        //比如我们数据表中的id字段是自动生成的
        return bookMapper.insertSelective(book);
    }

    @Override
    public int updateByPrimaryKey(Book book) {
        //根据主键字段准确地修改某一条记录。---update table set 所有字段
        return bookMapper.updateByPrimaryKey(book);
    }

    @Override
    public int delete(Long id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    /**
     *分页方法
     @Override
     public PageInfo<Book> getUsersByPage(Integer pageNum, Integer pageSize) {
     //DESC表示倒叙排列,这个引号里可填可不填
     //PageHelper.startPage(pageNum,pageSize,"id DESC");
     PageHelper.startPage(pageNum,pageSize,"id ASC");
     List<Book> users = bookMapper.selectAll();
     return new PageInfo<>(users);
     }
     */

}
