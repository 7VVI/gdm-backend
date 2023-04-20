package com.lsw.management.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsw.management.admin.model.dto.topicselection.TopicSelectionAddDto;
import com.lsw.management.admin.model.po.TopicSelection;
/**
 * @author lsw
 * @Date 2023/4/7 12:17
 * @desc 毕设管理
 */
public interface TopicSelectionService extends IService<TopicSelection> {

    Integer topicSelectionAdd(TopicSelectionAddDto addDto);

    Integer topicSelectionDelete(String ids);




}
