package com.lsw.management.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lsw.management.admin.model.dto.topicselection.TopicSelectionAddDto;
import com.lsw.management.admin.model.dto.topicselection.TopicSelectionQueryDto;
import com.lsw.management.admin.model.dto.topicselection.TopicSelectionUpdateDto;
import com.lsw.management.admin.model.po.TopicSelection;
import com.lsw.management.admin.model.vo.topicselection.TopicSelectionVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lsw
 * @Date 2023/4/7 12:17
 * @desc 毕设管理
 */
public interface TopicSelectionService extends IService<TopicSelection> {

    /**
     * 毕设题目新增
     * @param addDto
     * @param request
     * @return
     */
    Integer topicSelectionAdd(TopicSelectionAddDto addDto, HttpServletRequest request);

    /**
     * 毕设题目删除
     * @param ids
     * @return
     */
    Integer topicSelectionDelete(String ids);

    /**
     * 毕设题目修改
     * @param updateDto
     * @return
     */
    Integer topicSelectionUpdate(TopicSelectionUpdateDto updateDto);

    /**
     * 毕设题目分页查询
     * @param page
     * @param queryDto
     * @return
     */
    List<TopicSelectionVo> topicSelectionPageList(Page<TopicSelectionVo> page, TopicSelectionQueryDto queryDto);


}
