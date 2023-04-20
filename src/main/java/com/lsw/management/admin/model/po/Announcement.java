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
 * @desc 系统公告
 * @date: 2023/4/19  22:14
 */
@Data
@SqlSync(tableName = "announcement")
@ApiModel(value = "系统公告表",description = "")
@TableName("announcement")
public class Announcement implements Serializable{
    /** 主键 */

    @SqlColumn(field = "id",index = SqlColumn.SqlIndex.PRI,allowNull = false,autoIncrement = true,comment = "主键")
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(name = "主键",notes = "")
    private Integer id ;

    @SqlColumn(field = "title",comment = "公告标题")
    @TableField
    @ApiModelProperty(name = "公告标题",notes = "")
    private String title ;

    @SqlColumn(field = "content",comment = "公告内容",length = 1024)
    @TableField
    @ApiModelProperty(name = "公告内容",notes = "")
    private String content ;

    @SqlColumn(field = "is_top",comment = "是否置顶")
    @TableField("is_top")
    @ApiModelProperty(name = "是否置顶",notes = "")
    private Byte isTop ;

    @SqlColumn(field = "account_id",comment = "发布公告的账号---关联user_account表")
    @TableField("account_id")
    @ApiModelProperty(name = "发布公告的账号---关联user_account表",notes = "")
    private Integer accountId ;

    @SqlColumn(field = "deleted",comment = "是否删除 0否 1是",defaultValue = "0")
    @TableField
    @ApiModelProperty(name = "是否删除 0否 1是",notes = "")
    private Byte deleted ;

    @SqlColumn(field = "create_time",comment = "创建时间")
    @TableField("create_time")
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date createTime ;

    @SqlColumn(field = "update_time",comment = "更新时间")
    @TableField("update_time")
    @ApiModelProperty(name = "更新时间",notes = "")
    private Date updateTime ;
}
