package com.shroke.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by shroke on 2017/6/27.
 */
public class StockStructure {
    private Date 变动日期;
    private Date 公告日期;
    private String 变动原因;
    private BigDecimal 总股本;
    private BigDecimal 流通A股;
    private BigDecimal 高管股;
    private BigDecimal 限售A股;
    private BigDecimal 流通B股;
    private BigDecimal  限售B股;
    private BigDecimal 流通H股;
    private BigDecimal  国家股;
    private BigDecimal 国有法人股;
    private BigDecimal 境内发起人股;
    private BigDecimal 募集法人股;

    private BigDecimal 一般法人股;
    private BigDecimal 战略投资者持股;
    private BigDecimal 基金持股;
    private BigDecimal 转配股;
    private BigDecimal 内部职工股;
    private BigDecimal 优先股;

    public BigDecimal get战略投资者持股() {
        return 战略投资者持股;
    }

    public void set战略投资者持股(BigDecimal 战略投资者持股) {
        this.战略投资者持股 = 战略投资者持股;
    }

    public BigDecimal get基金持股() {
        return 基金持股;
    }

    public void set基金持股(BigDecimal 基金持股) {
        this.基金持股 = 基金持股;
    }

    public BigDecimal get转配股() {
        return 转配股;
    }

    public void set转配股(BigDecimal 转配股) {
        this.转配股 = 转配股;
    }

    public BigDecimal get内部职工股() {
        return 内部职工股;
    }

    public void set内部职工股(BigDecimal 内部职工股) {
        this.内部职工股 = 内部职工股;
    }

    public BigDecimal get优先股() {
        return 优先股;
    }

    public void set优先股(BigDecimal 优先股) {
        this.优先股 = 优先股;
    }

    public Date get变动日期() {
        return 变动日期;
    }

    public void set变动日期(Date 变动日期) {
        this.变动日期 = 变动日期;
    }
    public Date get公告日期() {
        return 公告日期;
    }

    public void set公告日期(Date 公告日期) {
        this.公告日期 = 公告日期;
    }

    public BigDecimal get总股本() {
        return 总股本;
    }

    public void set总股本(BigDecimal 总股本) {
        this.总股本 = 总股本;
    }

    public BigDecimal get流通A股() {
        return 流通A股;
    }

    public void set流通A股(BigDecimal 流通A股) {
        this.流通A股 = 流通A股;
    }

    public BigDecimal get高管股() {
        return 高管股;
    }

    public void set高管股(BigDecimal 高管股) {
        this.高管股 = 高管股;
    }

    public BigDecimal get限售A股() {
        return 限售A股;
    }

    public void set限售A股(BigDecimal 限售A股) {
        this.限售A股 = 限售A股;
    }

    public BigDecimal get流通B股() {
        return 流通B股;
    }

    public void set流通B股(BigDecimal 流通B股) {
        this.流通B股 = 流通B股;
    }

    public BigDecimal get限售B股() {
        return 限售B股;
    }

    public void set限售B股(BigDecimal 限售B股) {
        this.限售B股 = 限售B股;
    }

    public BigDecimal get流通H股() {
        return 流通H股;
    }

    public void set流通H股(BigDecimal 流通H股) {
        this.流通H股 = 流通H股;
    }

    public BigDecimal get国家股() {
        return 国家股;
    }

    public void set国家股(BigDecimal 国家股) {
        this.国家股 = 国家股;
    }

    public BigDecimal get国有法人股() {
        return 国有法人股;
    }

    public void set国有法人股(BigDecimal 国有法人股) {
        this.国有法人股 = 国有法人股;
    }

    public BigDecimal get境内发起人股() {
        return 境内发起人股;
    }

    public void set境内发起人股(BigDecimal 境内发起人股) {
        this.境内发起人股 = 境内发起人股;
    }

    public BigDecimal get募集法人股() {
        return 募集法人股;
    }

    public void set募集法人股(BigDecimal 募集法人股) {
        this.募集法人股 = 募集法人股;
    }

    public BigDecimal get一般法人股() {
        return 一般法人股;
    }

    public void set一般法人股(BigDecimal 一般法人股) {
        this.一般法人股 = 一般法人股;
    }

    public String get变动原因() {
        return 变动原因;
    }

    public void set变动原因(String 变动原因) {
        this.变动原因 = 变动原因;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
