package com.lsw.management.admin.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsw.management.admin.mapper.AnnouncementMapper;
import com.lsw.management.admin.model.dto.announcement.AnnouncementAddDto;
import com.lsw.management.admin.model.dto.announcement.AnnouncementQueryDto;
import com.lsw.management.admin.model.dto.announcement.announcementUpdateDto;
import com.lsw.management.admin.model.po.Announcement;
import com.lsw.management.admin.model.po.UserAccount;
import com.lsw.management.admin.model.vo.announcement.AnnouncementVo;
import com.lsw.management.admin.service.AnnouncementService;
import com.lsw.management.common.constants.ErrorCode;
import com.lsw.management.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author lsw
 * @Date 2023/4/7 12:17
 * @desc
 */
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement>
    implements AnnouncementService{

    @Resource
    private AnnouncementMapper announcementMapper;
    @Resource
    private UserAccountServiceImpl accountService;
    @Override
    public Integer announcementAdd(AnnouncementAddDto addDto, HttpServletRequest request) {
        final Announcement announcement = new Announcement();
        BeanUtils.copyProperties(addDto,announcement);
        announcement.setCreateTime(new Date());
        final UserAccount currentUser = accountService.getCurrentUser(request);
        announcement.setAccountId(currentUser.getId());
        announcementMapper.insert(announcement);
        return null;
    }

    @Override
    public Integer announcementDelete(String ids) {
        if(StringUtils.isBlank(ids)){
            throw new BusinessException(ErrorCode.INVALID_PARAMS);
        }
        String[] id = ids.split(",");
      return  announcementMapper.deleteBatchIds(Arrays.asList(id));
    }

    @Override
    public Integer announcementUpdate(announcementUpdateDto updateDto) {
        final Announcement announcement = new Announcement();
        BeanUtils.copyProperties(updateDto,announcement);
        announcement.setUpdateTime(new Date());
       return announcementMapper.updateById(announcement);
    }

    @Override
    public List<AnnouncementVo> announcementPageList(Page<AnnouncementVo> page, AnnouncementQueryDto announcementQueryDto) {
        QueryWrapper<Announcement> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("announcement.id,announcement.title,announcement.content,announcement.is_top",
                        "user_account.username")
                .eq("announcement.deleted", 0)
                .like(StringUtils.isNotBlank(announcementQueryDto.getTitle()),"announcement.title",announcementQueryDto.getTitle())
                .orderByDesc("user_account.create_time");
        return announcementMapper.selecAnnouncementPage(page, queryWrapper);
    }
}




