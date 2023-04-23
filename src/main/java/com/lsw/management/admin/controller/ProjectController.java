package com.lsw.management.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.lsw.management.admin.model.dto.project.ProjectAddDto;
import com.lsw.management.admin.model.dto.project.ProjectQueryDto;
import com.lsw.management.admin.model.dto.project.ProjectUpdateDto;
import com.lsw.management.admin.model.vo.project.ProjectVo;
import com.lsw.management.admin.service.ProjectService;
import com.lsw.management.common.http.response.ApiResponse;
import com.lsw.management.common.http.response.ResponseHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lsw
 * @desc 学生选题与进度
 * @date: 2023/4/22  11:07
 */
@RestController
@RequestMapping("/projectManage")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @GetMapping("/pageList")
    public ApiResponse<PageDTO<ProjectVo>> pageList(@RequestBody ProjectQueryDto queryDto) {
        long current = 1;
        long size = 10;
        if (queryDto.getCurrent() != null) {
            current = queryDto.getCurrent();
        }
        if (queryDto.getPageSize() != null) {
            size = queryDto.getPageSize();
        }
        Page<ProjectVo> page = new Page<>(current, size);
        PageDTO<ProjectVo> pageDTO = new PageDTO<>(current, size);
        List<ProjectVo> userVoList = projectService.projectPageList(page, queryDto);
        pageDTO.setRecords(userVoList);
        pageDTO.setTotal(page.getTotal());
        return ResponseHelper.success(pageDTO);
    }

    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody ProjectAddDto addDto) {
        return ResponseHelper.success(projectService.projectAdd(addDto));
    }

    @GetMapping("/delete")
    public ApiResponse<Integer> delete(@RequestParam String ids) {
        return ResponseHelper.success(projectService.projectDelete(ids));
    }

    @PostMapping("/update")
    public ApiResponse<Integer> update(@RequestBody ProjectUpdateDto updateDto) {
        return ResponseHelper.success(projectService.projectUpdate(updateDto));
    }


}
