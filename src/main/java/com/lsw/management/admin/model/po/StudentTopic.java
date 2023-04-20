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
 * @date: 2023/4/19  22:23
 */
@Data
@SqlSync(tableName = "student_topic")
@ApiModel(value = "学生_毕设题目关联表",description = "")
@TableName("student_topic")
public class StudentTopic implements Serializable,Cloneable{

    @SqlColumn(field = "id",index = SqlColumn.SqlIndex.PRI,allowNull = false,autoIncrement = true,comment = "主键")
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(name = "主键",notes = "")
    private Integer id ;

    @SqlColumn(field = "account_id",comment = "账号id 关联user_account表")
    @TableField("account_id")
    @ApiModelProperty(name = "账号id 关联user_account表",notes = "")
    private Integer accountId ;

    @SqlColumn(field = "topic_id",comment = "关联topic_selection表")
    @TableField("topic_id")
    @ApiModelProperty(name = "topicId",notes = "")
    private Integer topicId ;
}
