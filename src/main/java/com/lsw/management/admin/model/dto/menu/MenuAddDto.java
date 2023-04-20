package com.lsw.management.admin.model.dto.menu;

import lombok.Data;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/19  22:58
 */
@Data
public class MenuAddDto {
    private Integer pid ;

    private String title ;

    private String icon ;

    private String iconColor ;

    private String path ;

    private String name ;

    private Byte hidden ;

    private String permissions ;
}
