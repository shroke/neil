package com.shroke.parsing;

import com.shroke.util.LogMessageBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by shroke on 2017/6/24.
 */
public abstract class BaseParse {
    private static final Logger logger = LoggerFactory.getLogger(BaseParse.class);

    public Date parseSqlDate(String value){
        return Date.valueOf(value);
        //return new Date(System.currentTimeMillis());
    }

    public BigDecimal parseIssuePrice(String value){
        return NumberUtils.createBigDecimal(value);
    }

    public BigDecimal parseRegisteredCapital(String value){
        if(StringUtils.isBlank(value)){
            return BigDecimal.ZERO;
        }
        return NumberUtils.createBigDecimal(value.replace("万元", StringUtils.EMPTY));
    }

    public BigDecimal parseStockNum(String value){
        String tmp = value;
        if(StringUtils.isBlank(value)){
            return BigDecimal.ZERO;
        }
        value = value.replace("万股", StringUtils.EMPTY);
        value = value.replace("--", StringUtils.EMPTY);
        if(StringUtils.isBlank(value)){
            return BigDecimal.ZERO;
        }
        try {
            return NumberUtils.createBigDecimal(value.trim());
        }catch(NumberFormatException e){
            logger.error(LogMessageBuilder.MESSAGE_HOLDER,new LogMessageBuilder("NumberFormatException")
                    .addParameter("value",tmp));
            return BigDecimal.ZERO;
        }

    }


    protected String getTableValue(Element table, int i, int j){
        Elements trs = table.select("tr");
        if(i >= trs.size()){
            logger.error(LogMessageBuilder.MESSAGE_HOLDER,new LogMessageBuilder("基础信息未找到！")
                    .addParameter("table",table.outerHtml()).addParameter("行",i).addParameter("列",j));
            return StringUtils.EMPTY;
        }
        Elements tds = trs.get(i).select("td");
        if(j >= tds.size()){
            logger.error(LogMessageBuilder.MESSAGE_HOLDER,new LogMessageBuilder("基础信息未找到！")
                    .addParameter("table",table.outerHtml()).addParameter("行",i).addParameter("列",j));
            return StringUtils.EMPTY;
        }
        String text = tds.get(j).text();
        return text;
    }
}
