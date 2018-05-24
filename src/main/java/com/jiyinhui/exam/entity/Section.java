package com.jiyinhui.exam.entity;


import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class Section {
    private Integer id;
    private String name;
    private Subject subject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
