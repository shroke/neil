package com.shroke.controller;

import com.shroke.mapper.ExchangeMapper;
import com.shroke.mapper.StockBonusMapper;
import com.shroke.model.Exchange;
import com.shroke.model.StockBonus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by shroke on 2017/5/30.
 */
@RestController
public class TestContoller {
    @Autowired
    private ExchangeMapper exchangeMapper;
    @Autowired
    private StockBonusMapper stockBonusMapper;

    @RequestMapping("/stockBonus/{id}")
    public StockBonus stockBonus(@PathVariable("id") long id) {
        return stockBonusMapper.selectByPrimaryKey(id);
    }

    @RequestMapping(value="/stockBonus", method = RequestMethod.POST, consumes="application/json")
    public StockBonus saveStockBonus( @RequestBody StockBonus stu) {
        stockBonusMapper.insert(stu);
        return stu;
    }


    @RequestMapping("/exchange/{id}")
    public Exchange find(@PathVariable("id") long id) {
        return exchangeMapper.selectByPrimaryKey(id);
    }
    @RequestMapping("/exchange2/{id}")
    public Exchange find2(@PathVariable("id") long id) {
        return exchangeMapper.getById(id);
    }

    @RequestMapping(value="/exchange", method = RequestMethod.POST, consumes="application/json")
    public Exchange save( @RequestBody Exchange stu) {
        exchangeMapper.insert(stu);
        return stu;
    }

}
