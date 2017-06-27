package com.shroke.mapper;

import com.shroke.model.Stock;
import com.shroke.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StockMapper extends MyMapper<Stock> {
    @Select("select * from exchange where stock_code =#{stockCode}")
    public Stock selectByStockCode(@Param(value = "stockCode") String stockCode);
}