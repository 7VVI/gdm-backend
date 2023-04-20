package com.lsw.management.admin.model.dto.topicselection;

import lombok.Data;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/20  21:45
 */
@Data
public class TopicSelectionQueryDto {
    private String title ;

    private String teacher ;

    private String professional ;

    private String major ;

    private Integer studentType ;
}
