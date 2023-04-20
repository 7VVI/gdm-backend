package com.lsw.management.admin.model.dto.topicselection;

import lombok.Data;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/20  21:44
 */
@Data
public class TopicSelectionAddDto {
    private String title ;
    private String major ;
    private String direction;
    private Integer studentType ;
    private Integer studentNum ;
}
