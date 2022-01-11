package com.lzy.mapper;

import com.lzy.common.BaseMapper;
import com.lzy.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}