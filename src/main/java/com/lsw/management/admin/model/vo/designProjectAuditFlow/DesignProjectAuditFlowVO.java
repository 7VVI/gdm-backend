package com.lsw.management.admin.model.vo.designProjectAuditFlow;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/23  20:32
 */
@Data
public class DesignProjectAuditFlowVO {

    private Integer id ;

    private Integer state ;

    @TableField("title")
    private String title ;

    @TableField("department_audit_time")
    private Date departmentAuditTime ;

    @TableField("department_audit_user_id")
    private Integer departmentAuditUserId ;

    @TableField("department_audit_user_id")
    private Byte departmentAuditResult ;

    @TableField("school_audit_time")
    private Date schoolAuditTime ;

    @TableField("school_audit_user_id")
    private Integer schoolAuditUserId ;

    @TableField("school_audit_result")
    private Byte schoolAuditResult ;

    @TableField("department_audit_opinion")
    private String departmentAuditOpinion ;

    @TableField("school_audit_user_opinion")
    private String schoolAuditUserOpinion ;
}
