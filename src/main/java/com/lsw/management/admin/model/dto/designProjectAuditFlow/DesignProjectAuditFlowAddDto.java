package com.lsw.management.admin.model.dto.designProjectAuditFlow;

import lombok.Data;

import java.util.Date;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/23  20:23
 */
@Data
public class DesignProjectAuditFlowAddDto {

    private Integer topicId ;

    private Date departmentAuditTime ;

    private String departmentAuditUserId ;

    private Byte departmentAuditResult ;

    private String departmentAuditOpinion ;
}
