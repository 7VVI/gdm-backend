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
import java.util.Date;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/22  10:51
 */
@Data
@SqlSync(tableName = "design_project_audit_flow")
@ApiModel(value = "出题审计流程表",description = "")
@TableName(value="design_project_audit_flow")
public class DesignProjectAuditFlow implements Serializable{

    @SqlColumn(field = "id",index = SqlColumn.SqlIndex.PRI,allowNull = false,autoIncrement = true,comment = "主键")
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(name = "主键",notes = "")
    private Integer id ;

    @SqlColumn(field = "state",defaultValue = "0",comment = "当前审计状态，“0 未审核”、“1 系已审核”、“2 院已审核”等")
    @TableField("state")
    @ApiModelProperty(name = "当前审计状态，“0 未审核”、“1 系已审核”、“2 院已审核”等。",notes = "")
    private Integer state ;

    @SqlColumn(field = "topic_id",comment = "\"毕设题目 关联topic_selection表的id")
    @TableField("topic_id")
    @ApiModelProperty(name = "毕设题目 关联topic_selection表的id",notes = "")
    private Integer topicId ;

    @SqlColumn(field = "department_audit_time",comment = "系别审核时间")
    @TableField("department_audit_time")
    @ApiModelProperty(name = "系别审核时间",notes = "")
    private Date departmentAuditTime ;

    @SqlColumn(field = "department_audit_user_id",comment = "系负责人审核的用户ID")
    @TableField("department_audit_user_id")
    @ApiModelProperty(name = "系负责人审核的用户ID",notes = "")
    private Integer departmentAuditUserId ;

    @SqlColumn(field = "department_audit_result",comment = "系负责人审核结果 0驳回 1通过")
    @TableField("department_audit_result")
    @ApiModelProperty(name = "系负责人审核结果 0驳回 1通过",notes = "")
    private Byte departmentAuditResult ;

    @SqlColumn(field = "department_audit_opinion",comment = "系负责人审核备注")
    @TableField("department_audit_opinion")
    @ApiModelProperty(name = "系负责人审核备注",notes = "")
    private String departmentAuditOpinion ;

    @SqlColumn(field = "school_audit_time",comment = "院级审核时间")
    @TableField("school_audit_time")
    @ApiModelProperty(name = "院级审核时间",notes = "")
    private Date schoolAuditTime ;

    @SqlColumn(field = "school_audit_user_id",comment = "院负责人审核的用户ID")
    @TableField("school_audit_user_id")
    @ApiModelProperty(name = "院负责人审核的用户ID",notes = "")
    private Integer schoolAuditUserId ;

    @SqlColumn(field = "school_audit_result",comment = "院负责人审核结果 0驳回 1通过")
    @TableField("school_audit_result")
    @ApiModelProperty(name = "院负责人审核结果 0驳回 1通过",notes = "")
    private Byte schoolAuditResult ;

    @SqlColumn(field = "school_audit_user_opinion",comment = "院负责人审核备注")
    @TableField("school_audit_user_opinion")
    @ApiModelProperty(name = "院负责人审核备注",notes = "")
    private String schoolAuditUserOpinion ;
}
