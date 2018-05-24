package com.jiyinhui.exam.entity;


import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class Option {
    private Integer id;
    private String option;
    private Bool answer;
    private ItemPool itemPool;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Bool getAnswer() {
        return answer;
    }

    public void setAnswer(Bool answer) {
        this.answer = answer;
    }

    public ItemPool getItemPool() {
        return itemPool;
    }

    public void setItemPool(ItemPool itemPool) {
        this.itemPool = itemPool;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
