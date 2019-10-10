package com.instai.open.model;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author wangyue
 * @Date 2018/1/16 14:19
 * @Desc
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
