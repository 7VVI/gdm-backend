package com.lsw.management.admin.model.dto.designProjectAuditFlow;

import lombok.Data;

import java.util.Date;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/23  20:24
 */
@Data
public class DesignProjectAuditFlowUpdateDto {
    private Integer id ;
    private Integer state ;
    private Byte departmentAuditResult ;
    private Date schoolAuditTime ;
    private Integer schoolAuditUserId ;
    private Byte schoolAuditResult ;
    private String schoolAuditUserOpinion ;
}
