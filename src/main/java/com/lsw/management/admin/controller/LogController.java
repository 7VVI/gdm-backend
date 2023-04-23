package com.lsw.management.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.lsw.management.admin.model.dto.log.SysLogQueryDto;
import com.lsw.management.admin.model.vo.log.SysLogVo;
import com.lsw.management.admin.service.LogService;
import com.lsw.management.common.http.response.ApiResponse;
import com.lsw.management.common.http.response.ResponseHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lsw
 * @desc 系统日志 模块
 * @date: 2023/4/22  11:26
 */
@RestController
@RequestMapping("/logManage")
public class LogController {

    @Resource
    LogService logService;

    @PostMapping("/pageList")
    public ApiResponse<PageDTO<SysLogVo>> pageList(@RequestBody SysLogQueryDto queryDto){
        long current = 1;
        long size = 10;
        if(queryDto.getCurrent()!=null){
            current=queryDto.getCurrent();
        }
        if(queryDto.getPageSize()!=null){
            size=queryDto.getPageSize();
        }
        Page<SysLogVo> page = new Page<>(current, size);
        PageDTO<SysLogVo> pageDTO = new PageDTO<>(current, size);
        List<SysLogVo> userVoList = logService.pageList(page, queryDto);
        pageDTO.setRecords(userVoList);
        pageDTO.setTotal(page.getTotal());
        return ResponseHelper.success(pageDTO);
    }
}
