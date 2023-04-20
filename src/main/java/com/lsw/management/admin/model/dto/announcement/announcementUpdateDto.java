package com.lsw.management.admin.model.dto.announcement;

import lombok.Data;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/20  21:08
 */
@Data
public class announcementUpdateDto {
    private Integer id ;

    private String title ;

    private String content ;

    private Byte isTop ;
}
