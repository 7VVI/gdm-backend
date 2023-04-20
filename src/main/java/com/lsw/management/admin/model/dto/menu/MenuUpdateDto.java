package com.lsw.management.admin.model.dto.menu;

import lombok.Data;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/19  23:06
 */
@Data
public class MenuUpdateDto {
    private Integer menuId ;

    private Integer pid ;

    private String title ;

    private String icon ;

    private String iconColor ;

    private String path ;

    private String name ;

    private Byte hidden ;

    private String permissions ;
}
