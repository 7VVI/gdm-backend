package com.lsw.management.admin.model.dto.topicselection;

import com.lsw.management.admin.model.dto.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/20  21:45
 */
@Data
public class TopicSelectionQueryDto extends PageRequest implements Serializable {
    private String title ;

    private String teacher ;

    private String professional ;

    private String major ;

    private Integer studentType ;
}
