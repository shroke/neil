package com.shroke.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by shroke on 2017/5/30.
 */
public class StockShareholder {
    @Column(name="stock_id")
    private long stockId;
    @Column(name="shareholder_id")
    private long shareholderId;
    @Column(name="registration_date")
    private Date registrationDate;
    private BigDecimal ratio;
    private long quantity;

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    public long getShareholderId() {
        return shareholderId;
    }

    public void setShareholderId(long shareholderId) {
        this.shareholderId = shareholderId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
