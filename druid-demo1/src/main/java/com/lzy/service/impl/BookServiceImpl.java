package com.lzy.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.mapper.BookMapper;
import com.lzy.pojo.Book;
import com.lzy.service.BookService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzy
 * @since 2022-01-04
 */
@Service
//@DS("master")//不用@DS（）注解，采用的是默认数据源
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @DS("slave")//这个方法数据源切换到从数据库
    public Integer addBookToSlave(Book book) {
        return baseMapper.insert(book);
    }


}
