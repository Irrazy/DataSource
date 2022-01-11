package com.lzy.common;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.RowBoundsMapper;

public interface BaseMapper<T> extends Mapper<T>, ConditionMapper<T>, RowBoundsMapper<T> {
}
