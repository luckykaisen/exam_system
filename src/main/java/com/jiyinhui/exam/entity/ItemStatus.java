package com.jiyinhui.exam.entity;

import java.util.HashMap;
import java.util.Map;

public enum ItemStatus {
    MULTIPLE_CHOICE(1, "MULTIPLE_CHOICE", "多选题"),
    SINGLE_CHOICE(2, "SINGLE_CHOICE", "单选题"),
    TRUE_OR_FALSE(3, "TRUE_OR_FALSE", "判断题");

    private Integer id;
    private String code;
    private String description;

    private static final Map<Integer, ItemStatus> idItemStatus;
    private static final Map<String, ItemStatus> codeItemStatus;

    static {
        idItemStatus = new HashMap<>();
        codeItemStatus = new HashMap<>();

        for (ItemStatus dp : ItemStatus.values()) {
            idItemStatus.put(dp.getId(), dp);
            codeItemStatus.put(dp.getCode(), dp);
        }
    }

    ItemStatus(Integer id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public static ItemStatus fromId(Integer id) {
        return idItemStatus.get(id);
    }

    public static ItemStatus fromCode(String code) {
        return codeItemStatus.get(code);
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
