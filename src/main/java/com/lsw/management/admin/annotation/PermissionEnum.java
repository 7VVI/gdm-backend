package com.lsw.management.admin.annotation;

import lombok.Getter;

/**
 * @author lsw
 * @Date 2023/4/6 14:20
 * @desc 权限
 */
@Getter
public enum PermissionEnum {
    USER(0, "学生权限"),
    ADMIN(1, "管理员权限"),
    ADVISOR(2, "指导老师"),
    PROFESSIONAL_LEADER(3, "专业负责人"),
    HEAD_OF_COLLEGE(4, "学院负责人");

    PermissionEnum(Integer code, String name) {
        this.name = name;
        this.code = code;
    }

    /**
     * 权限名
     */
    private String name;

    /**
     * 权限编号
     */
    private Integer code;
}
