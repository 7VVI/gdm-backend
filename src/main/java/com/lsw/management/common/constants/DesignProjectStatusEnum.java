package com.lsw.management.common.constants;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/22  10:43
 */
public enum DesignProjectStatusEnum {
    NOT_AUDITED(0,"未审核"),

    DEPT_AUDITING(1,"系负责人审核中"),

    SCHOOL_AUDITING(2,"院负责人审核中"),

    APPROVED(3,"审核通过");

    private Integer code;

    DesignProjectStatusEnum(Integer code, String process) {
        this.code = code;
        this.process = process;
    }

    private String process;
}
