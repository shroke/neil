package com.shroke.controller;

import com.shroke.mapper.ExchangeMapper;
import com.shroke.mapper.StockBonusMapper;
import com.shroke.mapper.StockMapper;
import com.shroke.model.CompanyProfile;
import com.shroke.model.Exchange;
import com.shroke.model.Stock;
import com.shroke.model.StockBonus;
import com.shroke.parsing.StockProfileParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by shroke on 2017/5/30.
 */
@RestController
public class TestContoller {
    @Autowired
    private ExchangeMapper exchangeMapper;
    @Autowired
    private StockBonusMapper stockBonusMapper;
    @Autowired
    private StockProfileParse stockProfileParse;
    @Autowired
    private StockMapper stockMapper;

    @RequestMapping("/stock")
    public CompanyProfile saveStock(@RequestParam String from, @RequestParam String source){
        try {
            return stockProfileParse.processSource(source);
        }catch(IOException e){
            e.printStackTrace();
            return new CompanyProfile();
        }
    }

    @RequestMapping("/stock/{id}")
    public Stock getStock(@PathVariable("id") long id){
        return stockMapper.selectByPrimaryKey(id);
    }

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
