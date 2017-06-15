package com.shroke.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;

/**
 * Created by shroke on 2017/5/30.
 */
public class Shareholder {
    private String name;
    @Column(name="shareholder_type")
    private ShareholderType shareholderType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShareholderType getShareholderType() {
        return shareholderType;
    }

    public void setShareholderType(ShareholderType shareholderType) {
        this.shareholderType = shareholderType;
    }

    public enum ShareholderType{
        INDIVIDUAL, INSTITUTION, STATE,OTHER
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
