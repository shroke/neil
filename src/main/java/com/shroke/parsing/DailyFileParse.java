package com.shroke.parsing;

import com.google.common.collect.Lists;
import com.shroke.response.QuoteResponse;
import com.shroke.util.LogMessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by shroke on 2017/6/12.
 */
public class DailyFileParse {
    public static final Logger logger = LoggerFactory.getLogger(DailyFileParse.class);

    public static void process(String from,String source){
        try {
            processSource(from,source);
        }catch(ScriptException se){
            logger.error(LogMessageBuilder.MESSAGE_HOLDER
                    ,new LogMessageBuilder(se.getMessage()).addParameter("source",source),se);
        }
    }

    public static void processSource(String from,String source) throws ScriptException{
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("nashorn");
        engine.eval("var StockListPage = {};");
        engine.eval("StockListPage.GetData = function(){};");
        engine.eval(source);
        Map dataObject = (Map)engine.eval("dataArr");

        Collection dataArr = dataObject.values();
        List<QuoteResponse> quoteList = Lists.newArrayListWithCapacity(dataArr.size());
        Date date =new Date(System.currentTimeMillis());
        for(Object data:dataArr){
            Map dataMap =(Map) data;
            ////代码	名称	最新价	涨跌幅	昨收	今开	最高	最低	成交量	成交额	   换手	  振幅	量比
            //'600209','罗顿发展',12.73,10.03,  11.57,  11.52,  12.73,   11.45, 487910.03,597550224,11.44,11.06,1.71
            try {
                QuoteResponse quote = new QuoteResponse();
                quote.setFrom(from);
                quote.setDate(date);
                quote.setStockCode((String) dataMap.get("0"));
                quote.setStockName((String) dataMap.get("1"));
                quote.setUptodate(new BigDecimal(String.valueOf(dataMap.get("2"))));

                quote.setPreviousClose(new BigDecimal(String.valueOf(dataMap.get("4"))));
                quote.setOpen(new BigDecimal(String.valueOf(dataMap.get("5"))));
                quote.setHigh(new BigDecimal(String.valueOf(dataMap.get("6"))));
                quote.setLow(new BigDecimal(String.valueOf(dataMap.get("7"))));

                quote.setTurnover(new BigDecimal(String.valueOf(dataMap.get("8"))));
                quote.setTurnoverPrice(new BigDecimal(String.valueOf(dataMap.get("9"))));

                quote.setAmplitude(new BigDecimal(String.valueOf(dataMap.get("11"))));
                quote.setKdj(new BigDecimal(String.valueOf(dataMap.get("12"))));
                quoteList.add(quote);
            }catch (ClassCastException e){
                logger.error(LogMessageBuilder.MESSAGE_HOLDER
                        ,new LogMessageBuilder("parse daily data!").addParameter("dataMap.values()",dataMap.values()),e);
                continue;
            }
        }
        logger.debug(LogMessageBuilder.MESSAGE_HOLDER,quoteList);

        //TODO   持久化到
    }
}
