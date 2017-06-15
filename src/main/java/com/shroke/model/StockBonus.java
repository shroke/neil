package com.shroke.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by shroke on 2017/5/30.
 */
@Table(name = "stock_bonus")
public class StockBonus extends BaseEntity {

    @Column(name="stock_id")
    private long stockId;
    @Column(name="registration_date")
    private Date registrationDate;
    private Date year;
    @Column(name="cut_melon")
    private BigDecimal cutMelon;
    @Column(name="stock_ransfer")
    private int stockRansfer;

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public BigDecimal getCutMelon() {
        return cutMelon;
    }

    public void setCutMelon(BigDecimal cutMelon) {
        this.cutMelon = cutMelon;
    }

    public int getStockRansfer() {
        return stockRansfer;
    }

    public void setStockRansfer(int stockRansfer) {
        this.stockRansfer = stockRansfer;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
