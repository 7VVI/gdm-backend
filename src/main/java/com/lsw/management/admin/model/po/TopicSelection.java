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
 * @desc 选题表
 * @date: 2023/4/19  22:18
 */
@Data
@SqlSync(tableName = "topic_selection")
@ApiModel(value = "毕设选题表",description = "")
@TableName("topic_selection")
public class TopicSelection implements Serializable{

    @SqlColumn(field = "id",index = SqlColumn.SqlIndex.PRI,allowNull = false,autoIncrement = true,comment = "主键")
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(name = "主键",notes = "")
    private Integer id ;

    @SqlColumn(field = "title",comment = "毕设题目")
    @TableField
    @ApiModelProperty(name = "毕设题目",notes = "")
    private String title ;

    @SqlColumn(field = "teacher",comment = "出题老师")
    @TableField
    @ApiModelProperty(name = "出题老师",notes = "")
    private String teacher ;

    @SqlColumn(field = "professional",comment = "教师职称")
    @TableField
    @ApiModelProperty(name = "教师职称",notes = "")
    private String professional ;

    @SqlColumn(field = "major",comment = "适合专业")
    @TableField
    @ApiModelProperty(name = "适合专业",notes = "")
    private String major ;

    @SqlColumn(field = "direction",comment = "研究方向")
    @TableField
    @ApiModelProperty(name = "研究方向",notes = "")
    private String direction ;

    @SqlColumn(field = "student_type",comment = "学生类型 0本科生 1研究生 2博士生")
    @TableField("student_type")
    @ApiModelProperty(name = "学生类型 0本科生 1研究生 2博士生",notes = "")
    private Integer studentType ;

    @SqlColumn(field = "student_num",comment = "指导学生数",defaultValue = "0")
    @TableField("student_num")
    @ApiModelProperty(name = "指导学生数",notes = "")
    private Integer studentNum ;

    @SqlColumn(field = "create_time",comment = "创建时间")
    @TableField("create_time")
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date createTime ;

    @SqlColumn(field = "update_time",comment = "更新时间")
    @TableField("update_time")
    @ApiModelProperty(name = "更新时间",notes = "")
    private Date updateTime ;

    @SqlColumn(field = "deleted",comment = "是否删除 0否 1是",defaultValue = "0")
    @TableField
    @ApiModelProperty(name = "是否删除 0否 1是",notes = "")
    private Byte deleted ;
}
