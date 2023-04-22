package com.lsw.management.admin.model.dto.topicselection;

import lombok.Data;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/20  21:45
 */
@Data
public class TopicSelectionUpdateDto {
    private Integer id ;

    private String title ;

    private Integer major ;

    private Integer studentType ;

    private Integer studentNum;
}
