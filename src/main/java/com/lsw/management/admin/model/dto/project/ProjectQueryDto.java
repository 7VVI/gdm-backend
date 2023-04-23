package com.lsw.management.admin.model.dto.project;

import com.lsw.management.admin.model.dto.PageRequest;
import lombok.Data;

import java.util.Date;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/22  21:13
 */
@Data
public class ProjectQueryDto extends PageRequest {

    private Integer status ;

    private Date startDate ;

    private String endDate ;
}
