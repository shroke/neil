package com.shroke.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by shroke on 2017/5/30.
 */
public class Exchange extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}