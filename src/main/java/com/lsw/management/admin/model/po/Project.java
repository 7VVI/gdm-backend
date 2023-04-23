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
 * @desc 学生选题与进度
 * @date: 2023/4/22  10:46
 */
@Data
@SqlSync(tableName = "project")
@ApiModel(value = "毕业设计项目信息表",description = "")
@TableName("project")
public class Project implements Serializable{

    @SqlColumn(field = "id",index = SqlColumn.SqlIndex.PRI,allowNull = false,autoIncrement = true,comment = "主键")
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    @ApiModelProperty(name = "主键",notes = "")
    private Integer id ;

    @SqlColumn(field = "topic_id",comment = "关联topic_selection表 id ")
    @TableField("topic_id")
    @ApiModelProperty(name = "关联topic_selection表 id",notes = "")
    private Integer topicId ;

    @SqlColumn(field = "status",comment = "毕业设计状态：0进行中、1已完成、2已取消等 ")
    @TableField("status")
    @ApiModelProperty(name = "毕业设计状态：0进行中、1已完成、2已取消等",notes = "")
    private Integer status ;

    @SqlColumn(field = "start_date",comment = "毕业设计开始日期")
    @TableField("start_date")
    @ApiModelProperty(name = "毕业设计开始日期",notes = "")
    private Date startDate ;

    @SqlColumn(field = "end_date",comment = "毕业设计结束日期")
    @TableField("end_date")
    @ApiModelProperty(name = "毕业设计结束日期",notes = "")
    private Date endDate ;

    @SqlColumn(field = "student_id",comment = "学生 ID，关联user_account表 ")
    @TableField("student_id")
    @ApiModelProperty(name = "学生 ID，关联user_account表",notes = "")
    private Integer studentId ;

    @SqlColumn(field = "teacher_id",comment = "指导教师 ID，关联user_account表 ")
    @TableField("teacher_id")
    @ApiModelProperty(name = "指导教师 ID，关联user_account表",notes = "")
    private Integer teacherId ;

    @SqlColumn(field = "deleted",comment = "是否删除 0否 1是 ",defaultValue = "0")
    @TableField("deleted")
    @ApiModelProperty(name = "是否删除 0否 1是 ",notes = "")
    private Byte deleted;
}
