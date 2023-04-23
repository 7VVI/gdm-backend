package com.lsw.management.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsw.management.admin.model.po.TopicSelection;
import com.lsw.management.admin.model.vo.topicselection.TopicSelectionVo;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * @author lsw
 * @Date 2023/4/7 12:17
 * @desc
 */
public interface TopicSelectionMapper extends BaseMapper<TopicSelection> {

    List<TopicSelectionVo> selectopicSelectionPage(Page<TopicSelectionVo> page, @Param(Constants.WRAPPER)QueryWrapper<TopicSelection> ew);
}




