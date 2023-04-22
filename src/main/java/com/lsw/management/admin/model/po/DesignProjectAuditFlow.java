package com.lsw.management.admin.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lsw.management.common.util.sychronize.annotation.SqlColumn;
import com.lsw.management.common.util.sychronize.annotation.SqlSync;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/22  10:51
 */
@Data
@SqlSync(tableName = "design_project_audit_flow")
@ApiModel(value = "出题审计流程表",description = "")
@TableName(value="design_project_audit_flow")
public class DesignProjectAuditFlow implements Serializable,Cloneable{
    /** 主键 */
    @SqlColumn(field = "id",index = SqlColumn.SqlIndex.PRI,allowNull = false,autoIncrement = true,comment = "主键")
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(name = "主键",notes = "")
    private Integer id ;

    @SqlColumn(field = "audit_dept_user_id",comment = "示审核部门的用户ID，外键，指向用户信息表")
    @TableField("audit_dept_user_id")
    @ApiModelProperty(name = "示审核部门的用户ID，外键，指向用户信息表。",notes = "")
    private Integer auditDeptUserId ;

    @SqlColumn(field = "dept_approve_date",comment = "表示部门审核通过的时间")
    @TableField
    @ApiModelProperty(name = "表示部门审核通过的时间",notes = "")
    private String deptApproveDate ;

    @SqlColumn(field = "dept_approve_comment",comment = "表示部门审核通过的备注和意见")
    @TableField("dept_approve_comment")
    @ApiModelProperty(name = "表示部门审核通过的备注和意见",notes = "")
    private String deptApproveComment ;

    @SqlColumn(field = "topic_id",comment = "审核的题目；关联出题表")
    @TableField("topic_id")
    @ApiModelProperty(name = "审核的题目；关联出题表",notes = "")
    private Integer topicId ;

    @SqlColumn(field = "status",comment = "0驳回 1通过")
    @TableField
    @ApiModelProperty(name = "0驳回 1通过",notes = "")
    private Byte status ;
}
