package com.jiyinhui.exam.entity;


import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class ItemPool {
    private Integer id;
    private String topic;
    private Double score;
    private ItemStatus itemStatus;
    private Bool isDelete;
    private Section section;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Bool getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Bool isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

