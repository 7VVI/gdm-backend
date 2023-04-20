package com.lsw.management.admin.model.vo.announcement;

import lombok.Data;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/20  21:22
 */
@Data
public class AnnouncementVo {
    private Integer id ;
    private String title ;
    private String content ;
    private Byte isTop ;
}
