package com.jiyinhui.exam.entity;

public class ExaminationPaperOption {
    private Integer id;
    private ItemPool itemPool;
    private ExaminationPaper examinationPaper;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemPool getItemPool() {
        return itemPool;
    }

    public void setItemPool(ItemPool itemPool) {
        this.itemPool = itemPool;
    }

    public ExaminationPaper getExaminationPaper() {
        return examinationPaper;
    }

    public void setExaminationPaper(ExaminationPaper examinationPaper) {
        this.examinationPaper = examinationPaper;
    }
}
