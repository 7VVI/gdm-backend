package com.lsw.management.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lsw.management.admin.model.dto.announcement.AnnouncementAddDto;
import com.lsw.management.admin.model.dto.announcement.AnnouncementQueryDto;
import com.lsw.management.admin.model.dto.announcement.announcementUpdateDto;
import com.lsw.management.admin.model.po.Announcement;
import com.lsw.management.admin.model.vo.announcement.AnnouncementVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lsw
 * @Date 2023/4/7 12:17
 * @desc
 */

public interface AnnouncementService extends IService<Announcement> {

    /**
     * 公告添加
     * @param addDto /
     * @return /
     */
    Integer  announcementAdd(AnnouncementAddDto addDto, HttpServletRequest request);

    /**
     * 公告删除
     * @param ids
     * @return
     */
    Integer announcementDelete(String ids);


    /**
     * 公告更新
     * @param updateDto
     * @return
     */
    Integer announcementUpdate(announcementUpdateDto updateDto);

    /**
     * 公告分页查询
     * @return
     */
    List<AnnouncementVo> announcementPageList(Page<AnnouncementVo> page, AnnouncementQueryDto announcementQueryDto);


}
