package com.lsw.management.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.lsw.management.admin.model.dto.designProjectAuditFlow.DesignProjectAuditFlowAddDto;
import com.lsw.management.admin.model.dto.designProjectAuditFlow.DesignProjectAuditFlowQueryDto;
import com.lsw.management.admin.model.dto.designProjectAuditFlow.DesignProjectAuditFlowUpdateDto;
import com.lsw.management.admin.model.vo.designProjectAuditFlow.DesignProjectAuditFlowVO;
import com.lsw.management.admin.service.DesignProjectAuditFlowService;
import com.lsw.management.common.http.response.ApiResponse;
import com.lsw.management.common.http.response.ResponseHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: lsw
 * @desc 出题审计流程表
 * @date: 2023/4/22  11:14
 */
@RestController
@RequestMapping("/ designProjectAuditFlowManage")
public class DesignProjectAuditFlowController {

    @Resource
    DesignProjectAuditFlowService designProjectAuditFlowService;

    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody DesignProjectAuditFlowAddDto addDto, HttpServletRequest request){
        return ResponseHelper.success(designProjectAuditFlowService.designProjectAuditFlowAdd(addDto,request));
    }

    @GetMapping("/delete")
    public ApiResponse<Integer> delete(String ids){
        return ResponseHelper.success(designProjectAuditFlowService.designProjectAuditFlowDelete(ids));
    }

    @PostMapping("/update")
    public ApiResponse<Integer> update(@RequestBody DesignProjectAuditFlowUpdateDto updateDto,HttpServletRequest request){
        return ResponseHelper.success(designProjectAuditFlowService.designProjectAuditFlowUpdate(updateDto,request));
    }

    @PostMapping("/pageList")
    public ApiResponse<PageDTO<DesignProjectAuditFlowVO>> pageList(@RequestBody DesignProjectAuditFlowQueryDto queryDto){
        long current = 1;
        long size = 10;
        if(queryDto.getCurrent()!=null){
            current=queryDto.getCurrent();
        }
        if(queryDto.getPageSize()!=null){
            size=queryDto.getPageSize();
        }
        Page<DesignProjectAuditFlowVO> page = new Page<>(current, size);
        PageDTO<DesignProjectAuditFlowVO> pageDTO = new PageDTO<>(current, size);
        List<DesignProjectAuditFlowVO> userVoList = designProjectAuditFlowService.announcementPageList(page, queryDto);
        pageDTO.setRecords(userVoList);
        pageDTO.setTotal(page.getTotal());
        return ResponseHelper.success(pageDTO);
    }

}
