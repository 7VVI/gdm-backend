package com.lsw.management.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.lsw.management.admin.model.dto.topicselection.TopicSelectionAddDto;
import com.lsw.management.admin.model.dto.topicselection.TopicSelectionQueryDto;
import com.lsw.management.admin.model.dto.topicselection.TopicSelectionUpdateDto;
import com.lsw.management.admin.model.vo.topicselection.TopicSelectionVo;
import com.lsw.management.admin.service.TopicSelectionService;
import com.lsw.management.common.http.response.ApiResponse;
import com.lsw.management.common.http.response.ResponseHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: lsw
 * @desc 教师出题管理模块
 * @date: 2023/4/22  9:44
 */
@RestController
@RequestMapping("/topicSelectionManage")
public class TopicSelectionController {

    @Resource
    TopicSelectionService topicSelectionService;

    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody TopicSelectionAddDto topicSelectionAddDto, HttpServletRequest request){
        return ResponseHelper.success(topicSelectionService.topicSelectionAdd(topicSelectionAddDto,request));
    }

    @GetMapping("/delete")
    public ApiResponse<Integer> delete(String ids){
        return ResponseHelper.success(topicSelectionService.topicSelectionDelete(ids));
    }

    @PostMapping("/update")
    public ApiResponse<Integer> update(@RequestBody TopicSelectionUpdateDto updateDto){
        return ResponseHelper.success(topicSelectionService.topicSelectionUpdate(updateDto));
    }

    @PostMapping("/pageList")
    public ApiResponse<PageDTO<TopicSelectionVo>> pageList(@RequestBody TopicSelectionQueryDto topicSelectionQueryDto){
        long current = 1;
        long size = 10;
        if(topicSelectionQueryDto.getCurrent()!=null){
            current=topicSelectionQueryDto.getCurrent();
        }
        if(topicSelectionQueryDto.getPageSize()!=null){
            size=topicSelectionQueryDto.getPageSize();
        }
        Page<TopicSelectionVo> page = new Page<>(current, size);
        PageDTO<TopicSelectionVo> pageDTO = new PageDTO<>(current, size);
        List<TopicSelectionVo> userVoList = topicSelectionService.topicSelectionPageList(page, topicSelectionQueryDto);
        pageDTO.setRecords(userVoList);
        pageDTO.setTotal(page.getTotal());
        return ResponseHelper.success(pageDTO);
    }
}
