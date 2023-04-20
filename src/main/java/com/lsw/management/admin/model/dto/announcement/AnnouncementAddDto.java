package com.lsw.management.admin.model.dto.announcement;

import lombok.Data;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/20  21:07
 */
@Data
public class AnnouncementAddDto {
    private String title ;

    private String content ;

    private Byte isTop ;
}
