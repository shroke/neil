package com.shroke.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by shroke on 2017/5/30.
 */
public class Stock  extends BaseEntity {
    @Column(name="stock_code")
    private String stockCode;
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
    @Column(name="stock_status")
    @Enumerated(EnumType.STRING)
    private StockStatus stockStatus;

    private CompanyProfile companyProfile;

    public CompanyProfile getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(CompanyProfile companyProfile) {
        this.companyProfile = companyProfile;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
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

    public StockStatus getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(StockStatus stockStatus) {
        this.stockStatus = stockStatus;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
