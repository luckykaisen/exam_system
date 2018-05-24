package com.jiyinhui.exam.entity;

import java.util.HashMap;
import java.util.Map;

public enum UserStatus {
    STUDENT(1, "STUDENT", "学生"),
    TEACHER(2, "TEACHER", "教师"),
    ADMIN(3, "ADMIN", "管理员");

    private Integer id;
    private String code;
    private String description;

    private static final Map<Integer, UserStatus> idUserStatus;
    private static final Map<String, UserStatus> codeUserStatus;

    static {
        idUserStatus = new HashMap<>();
        codeUserStatus = new HashMap<>();

        for (UserStatus dp : UserStatus.values()) {
            idUserStatus.put(dp.getId(), dp);
            codeUserStatus.put(dp.getCode(), dp);
        }
    }

    UserStatus(Integer id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public static UserStatus fromId(Integer id) {
        return idUserStatus.get(id);
    }

    public static UserStatus fromCode(String code) {
        return codeUserStatus.get(code);
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
