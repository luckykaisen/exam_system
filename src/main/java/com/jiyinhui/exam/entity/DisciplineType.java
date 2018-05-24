package com.jiyinhui.exam.entity;

import java.util.HashMap;
import java.util.Map;

public enum DisciplineType {
    ARTS(1, "ARTS", "文科"),
    SCIENCE(2, "SCIENCE", "理科");

    private Integer id;
    private String code;
    private String description;

    private static final Map<Integer, DisciplineType> idDisciplineType;
    private static final Map<String, DisciplineType> codeDisciplineType;

    static {
        idDisciplineType = new HashMap<>();
        codeDisciplineType = new HashMap<>();

        for (DisciplineType dp : DisciplineType.values()) {
            idDisciplineType.put(dp.getId(), dp);
            codeDisciplineType.put(dp.getCode(), dp);
        }
    }

    DisciplineType(Integer id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public static DisciplineType fromId(Integer id) {
        return idDisciplineType.get(id);
    }

    public static DisciplineType fromCode(String code) {
        return codeDisciplineType.get(code);
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
