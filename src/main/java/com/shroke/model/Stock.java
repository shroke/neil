package com.shroke.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by shroke on 2017/5/30.
 */
public class Stock {
    private String stockode;
    private String name;

    @Column(name="exchange_id")
    private long exchangeId;
    @Column(name="industries_id")
    private long industriesId;
    @Column(name="listed_date")
    private Date listedDate;
    @Column(name="sum_shares")
    private long sumShares;
    @Column(name="tradable_shares")
    private long tradableShares;
    @Column(name="current_price")
    private BigDecimal currentPrice;
    private StockStatus status;

    public String getStockode() {
        return stockode;
    }

    public void setStockode(String stockode) {
        this.stockode = stockode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(long exchangeId) {
        this.exchangeId = exchangeId;
    }

    public long getIndustriesId() {
        return industriesId;
    }

    public void setIndustriesId(long industriesId) {
        this.industriesId = industriesId;
    }

    public Date getListedDate() {
        return listedDate;
    }

    public void setListedDate(Date listedDate) {
        this.listedDate = listedDate;
    }

    public long getSumShares() {
        return sumShares;
    }

    public void setSumShares(long sumShares) {
        this.sumShares = sumShares;
    }

    public long getTradableShares() {
        return tradableShares;
    }

    public void setTradableShares(long tradableShares) {
        this.tradableShares = tradableShares;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public StockStatus getStatus() {
        return status;
    }

    public void setStatus(StockStatus status) {
        this.status = status;
    }

    public enum  StockStatus {
        STOP, ACTIVE, OTHER;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
