package com.lsw.management.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.lsw.management.admin.annotation.Log;
import com.lsw.management.admin.model.dto.announcement.AnnouncementAddDto;
import com.lsw.management.admin.model.dto.announcement.AnnouncementQueryDto;
import com.lsw.management.admin.model.dto.announcement.announcementUpdateDto;
import com.lsw.management.admin.model.vo.announcement.AnnouncementVo;
import com.lsw.management.admin.service.AnnouncementService;
import com.lsw.management.common.http.response.ApiResponse;
import com.lsw.management.common.http.response.ResponseHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: lsw
 * @desc 系统公告模块
 * @date: 2023/4/20  21:02
 */
@RestController
@RequestMapping("/announcementManage")
public class AnnouncementController {

    @Resource
    AnnouncementService announcementService;

    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody AnnouncementAddDto announcementAddDto, HttpServletRequest request){
        return ResponseHelper.success(announcementService.announcementAdd(announcementAddDto,request));
    }

    @GetMapping("/delete")
    public ApiResponse<Integer> delete(String ids){
        return ResponseHelper.success(announcementService.announcementDelete(ids));
    }

    @PostMapping("/update")
    public ApiResponse<Integer> update(@RequestBody announcementUpdateDto updateDto){
        return ResponseHelper.success(announcementService.announcementUpdate(updateDto));
    }

    @Log
    @PostMapping("/pageList")
    public ApiResponse<PageDTO<AnnouncementVo>> pageList(@RequestBody AnnouncementQueryDto announcementQueryDto){
        long current = 1;
        long size = 10;
        if(announcementQueryDto.getCurrent()!=null){
            current=announcementQueryDto.getCurrent();
        }
        if(announcementQueryDto.getPageSize()!=null){
            size=announcementQueryDto.getPageSize();
        }
        Page<AnnouncementVo> page = new Page<>(current, size);
        PageDTO<AnnouncementVo> pageDTO = new PageDTO<>(current, size);
        List<AnnouncementVo> userVoList = announcementService.announcementPageList(page, announcementQueryDto);
        pageDTO.setRecords(userVoList);
        pageDTO.setTotal(page.getTotal());
        return ResponseHelper.success(pageDTO);
    }

}
