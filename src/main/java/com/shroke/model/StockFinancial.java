package com.shroke.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by shroke on 2017/5/30.
 */
public class StockFinancial {
    @Column(name="stock_id")
    private long stockId;
    private Date year;
    //财务年
    private int quater;
    //每股收益
    @Column(name="earnings_per_share")
    private BigDecimal earningsPerShare;
    //总资产
    @Column(name="market_cap")
    private BigDecimal marketCap;
    //净资产
    @Column(name="net_asset")
    private BigDecimal netAsset;
    //负债
    private BigDecimal liabilities;
    //未分配利润
    @Column(name="undistributed_profit")
    private BigDecimal undistributedProfit;
    //每股股价与每股收益的比率
    @Column(name="forward_price_to_earnings")
    private BigDecimal forwardPriceToEarnings;

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public int getQuater() {
        return quater;
    }

    public void setQuater(int quater) {
        this.quater = quater;
    }

    public BigDecimal getEarningsPerShare() {
        return earningsPerShare;
    }

    public void setEarningsPerShare(BigDecimal earningsPerShare) {
        this.earningsPerShare = earningsPerShare;
    }

    public BigDecimal getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(BigDecimal marketCap) {
        this.marketCap = marketCap;
    }

    public BigDecimal getNetAsset() {
        return netAsset;
    }

    public void setNetAsset(BigDecimal netAsset) {
        this.netAsset = netAsset;
    }

    public BigDecimal getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(BigDecimal liabilities) {
        this.liabilities = liabilities;
    }

    public BigDecimal getUndistributedProfit() {
        return undistributedProfit;
    }

    public void setUndistributedProfit(BigDecimal undistributedProfit) {
        this.undistributedProfit = undistributedProfit;
    }

    public BigDecimal getForwardPriceToEarnings() {
        return forwardPriceToEarnings;
    }

    public void setForwardPriceToEarnings(BigDecimal forwardPriceToEarnings) {
        this.forwardPriceToEarnings = forwardPriceToEarnings;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
