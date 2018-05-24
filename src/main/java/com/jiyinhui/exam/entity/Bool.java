package com.jiyinhui.exam.entity;

import java.util.HashMap;
import java.util.Map;

public enum Bool {
    Y(1, "Y", "true"),
    N(2, "N", "false");

    private Integer id;
    private String code;
    private String description;

    private static final Map<Integer, Bool> idBool;
    private static final Map<String, Bool> codeBool;

    static {
        idBool = new HashMap<>();
        codeBool = new HashMap<>();

        for (Bool dp : Bool.values()) {
            idBool.put(dp.getId(), dp);
            codeBool.put(dp.getCode(), dp);
        }
    }

    Bool(Integer id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public static Bool fromId(Integer id) {
        return idBool.get(id);
    }

    public static Bool fromCode(String code) {
        return codeBool.get(code);
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
