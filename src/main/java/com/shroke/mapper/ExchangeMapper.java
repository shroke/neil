package com.shroke.mapper;

import com.shroke.model.Exchange;
import com.shroke.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ExchangeMapper extends MyMapper<Exchange> {

    @Select("select id,name,insert_time as insertTime,update_time as updateTime from exchange where id =#{id}")
    public Exchange getById(@Param(value = "id")long id);

    @Select("select id,name,insert_time as insertTime,update_time as updateTime from exchange where name =#{name}")
    public Exchange getByName(@Param(value = "name")String name);
}