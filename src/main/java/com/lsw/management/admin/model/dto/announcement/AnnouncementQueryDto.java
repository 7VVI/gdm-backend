package com.lsw.management.admin.model.dto.announcement;

import com.lsw.management.admin.model.dto.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/20  21:10
 */
@Data
public class AnnouncementQueryDto extends PageRequest implements Serializable {
    private String title ;
}
