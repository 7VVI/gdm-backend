package com.lsw.management.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lsw.management.admin.model.dto.project.ProjectAddDto;
import com.lsw.management.admin.model.dto.project.ProjectQueryDto;
import com.lsw.management.admin.model.dto.project.ProjectUpdateDto;
import com.lsw.management.admin.model.po.Project;
import com.lsw.management.admin.model.vo.project.ProjectVo;

import java.util.List;

/**
 * @author lsw
 * @Date 2023/4/6 15:25
 * @desc
 */
public interface ProjectService extends IService<Project> {

    /**
     * 学生选题添加
     * @param addDto
     * @return
     */
    Integer projectAdd(ProjectAddDto addDto);

    /**
     * 学生选题删除
     * @param ids
     * @return
     */
    Integer projectDelete(String ids);

    Integer projectUpdate(ProjectUpdateDto updateDto);

    List<ProjectVo> projectPageList(Page<ProjectVo> page, ProjectQueryDto queryDto);
}
