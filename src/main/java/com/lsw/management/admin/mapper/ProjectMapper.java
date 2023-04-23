package com.lsw.management.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsw.management.admin.model.po.Project;
import com.lsw.management.admin.model.vo.project.ProjectVo;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
* @author 17533
* @description 针对表【project】的数据库操作Mapper
* @createDate 2023-04-22 11:03:27
* @Entity generator.domain.Project
*/
public interface ProjectMapper extends BaseMapper<Project> {

    /**
     * 分页查询
     * @param page /
     * @param ew /
     * @return /
     */
    List<ProjectVo> selectProjectPage(Page<ProjectVo> page,  @Param(Constants.WRAPPER)QueryWrapper<Project> ew);
}




