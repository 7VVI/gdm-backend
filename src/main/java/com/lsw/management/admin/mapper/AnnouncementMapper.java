package com.lsw.management.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsw.management.admin.model.po.Announcement;
import com.lsw.management.admin.model.vo.announcement.AnnouncementVo;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * @author lsw
 * @Date 2023/4/6 15:55
 * @desc
 */
public interface AnnouncementMapper extends BaseMapper<Announcement> {

    List<AnnouncementVo> selecAnnouncementPage(Page<AnnouncementVo> page, @Param(Constants.WRAPPER) Wrapper<Announcement> ew);
}




