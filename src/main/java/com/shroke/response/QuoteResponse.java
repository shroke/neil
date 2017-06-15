package com.shroke.response;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by shroke on 2017/6/11.
 */
public class QuoteResponse {
    //代码	名称	最新价	涨跌幅	昨收	今开	最高	最低	成交量	成交额	换手	振幅	量比
    private String from;
    private Date date;
    private String stockCode;
    private String stockName;
    private BigDecimal uptodate;

    private BigDecimal previousClose;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal turnover;
    private BigDecimal turnoverPrice;
    private BigDecimal amplitude;
    private BigDecimal kdj;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public BigDecimal getUptodate() {
        return uptodate;
    }

    public void setUptodate(BigDecimal uptodate) {
        this.uptodate = uptodate;
    }

    public BigDecimal getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(BigDecimal previousClose) {
        this.previousClose = previousClose;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

    public BigDecimal getTurnoverPrice() {
        return turnoverPrice;
    }

    public void setTurnoverPrice(BigDecimal turnoverPrice) {
        this.turnoverPrice = turnoverPrice;
    }

    public BigDecimal getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(BigDecimal amplitude) {
        this.amplitude = amplitude;
    }

    public BigDecimal getKdj() {
        return kdj;
    }

    public void setKdj(BigDecimal kdj) {
        this.kdj = kdj;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
