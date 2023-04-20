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
 * @desc 系统菜单
 * @date: 2023/4/19  22:08
 */
@Data
@SqlSync(tableName = "menu")
@ApiModel(value = "菜单信息表",description = "")
@TableName("menu")
public class Menu implements Serializable{

    public static final String DELETED="deleted";

    @SqlColumn(field = "menu_id",index = SqlColumn.SqlIndex.PRI,allowNull = false,autoIncrement = true,comment = "主键")
    @TableId(value = "menu_id",type = IdType.ASSIGN_ID)
    @ApiModelProperty(name = "主键",notes = "")
    private Integer menuId ;

    @SqlColumn(field = "pid",comment = "上级菜单ID")
    @TableField
    @ApiModelProperty(name = "上级菜单ID",notes = "")
    private Integer pid ;

    @SqlColumn(field = "title",comment = "菜单标题")
    @TableField
    @ApiModelProperty(name = "菜单标题",notes = "")
    private String title ;

    @SqlColumn(field = "icon",comment = "菜单图标")
    @TableField
    @ApiModelProperty(name = "菜单图标",notes = "")
    private String icon ;

    @SqlColumn(field = "icon_color",comment = "菜单图标颜色")
    @TableField("icon_color")
    @ApiModelProperty(name = "菜单图标颜色",notes = "")
    private String iconColor ;

    @SqlColumn(field = "path",comment = "路由")
    @TableField
    @ApiModelProperty(name = "路由",notes = "")
    private String path ;

    @SqlColumn(field = "name",comment = "组件名字")
    @TableField
    @ApiModelProperty(name = "组件名字",notes = "")
    private String name ;

    @SqlColumn(field = "hidden",comment = "是否隐藏 0否 1是",defaultValue = "0")
    @TableField
    @ApiModelProperty(name = "是否隐藏 0否 1是",notes = "")
    private Byte hidden ;

    @SqlColumn(field = "permissions",comment = "允许访问的权限",defaultValue = "0")
    @TableField
    @ApiModelProperty(name = "允许访问的权限",notes = "")
    private String permissions ;


    @SqlColumn(field = "create_by",comment = "创建者")
    @TableField("create_by")
    @ApiModelProperty(name = "创建者",notes = "")
    private String createBy ;

    @SqlColumn(field = "update_by",comment = "更新者")
    @TableField("update_by")
    @ApiModelProperty(name = "更新者",notes = "")
    private String updateBy ;

    @SqlColumn(field = "create_time",comment = "创建时间")
    @TableField("create_time")
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date createTime ;

    @SqlColumn(field = "update_time",comment = "更新时间")
    @TableField("update_time")
    @ApiModelProperty(name = "更新时间",notes = "")
    private Date updateTime ;

    @SqlColumn(field = "deleted",comment = "是都删除 0否1是",defaultValue = "0")
    @TableField
    @ApiModelProperty(name = "是都删除 0否1是",notes = "")
    private Byte deleted ;

}
