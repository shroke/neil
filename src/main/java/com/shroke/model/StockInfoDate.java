package com.shroke.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by shroke on 2017/5/30.
 */
public class StockInfoDate {
    @Column(name="stock_id")
    private long stockId;
    private Date date;
    private BigDecimal open;
    private BigDecimal close;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal change;
    @Column(name="share_change_ratio")
    private BigDecimal shareChangeRatio;
    //每股股价与净资产的比率
    @Column(name="price_to_book")
    private BigDecimal priceToBook;
    //总市值除以主营业务收入
    @Column(name="price_to_sales")
    private BigDecimal priceToSales;
    //股价现金流比率
    @Column(name="price_to_cash_flow")
    private BigDecimal priceToCashFlow;

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
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

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public BigDecimal getShareChangeRatio() {
        return shareChangeRatio;
    }

    public void setShareChangeRatio(BigDecimal shareChangeRatio) {
        this.shareChangeRatio = shareChangeRatio;
    }

    public BigDecimal getPriceToBook() {
        return priceToBook;
    }

    public void setPriceToBook(BigDecimal priceToBook) {
        this.priceToBook = priceToBook;
    }

    public BigDecimal getPriceToSales() {
        return priceToSales;
    }

    public void setPriceToSales(BigDecimal priceToSales) {
        this.priceToSales = priceToSales;
    }

    public BigDecimal getPriceToCashFlow() {
        return priceToCashFlow;
    }

    public void setPriceToCashFlow(BigDecimal priceToCashFlow) {
        this.priceToCashFlow = priceToCashFlow;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
