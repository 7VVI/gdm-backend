package com.lsw.management.admin.model.dto.topicselection;

import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/20  21:44
 */
@Data
public class TopicSelectionAddDto {

    private String title;

    private Integer major;

    private String direction;

    private Integer studentType;

    @Pattern(regexp = "\\d+",message = "Only digits are allowed")
    private Integer studentNum;
}
