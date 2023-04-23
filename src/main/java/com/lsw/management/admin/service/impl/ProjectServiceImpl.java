package com.lsw.management.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsw.management.admin.mapper.ProjectMapper;
import com.lsw.management.admin.model.dto.project.ProjectAddDto;
import com.lsw.management.admin.model.dto.project.ProjectQueryDto;
import com.lsw.management.admin.model.dto.project.ProjectUpdateDto;
import com.lsw.management.admin.model.po.Project;
import com.lsw.management.admin.model.vo.project.ProjectVo;
import com.lsw.management.admin.service.ProjectService;
import com.lsw.management.common.constants.ErrorCode;
import com.lsw.management.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author lsw
 * @Date 2023/4/6 15:25
 * @desc
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project>
    implements ProjectService{

    @Resource
    ProjectMapper projectMapper;

    @Override
    public Integer projectAdd(ProjectAddDto addDto) {
        Project project = new Project();
        BeanUtils.copyProperties(addDto,project);
      return  projectMapper.insert(project);
    }

    @Override
    public Integer projectDelete(String ids) {
        if(StringUtils.isBlank(ids)){
            throw new BusinessException(ErrorCode.INVALID_PARAMS);
        }
        String[] id = ids.split(",");
        return   projectMapper.deleteBatchIds(Arrays.asList(id));
    }

    @Override
    public Integer projectUpdate(ProjectUpdateDto updateDto) {
        Project project = new Project();
        BeanUtils.copyProperties(updateDto,project);
        return projectMapper.updateById(project);
    }

    @Override
    public List<ProjectVo> projectPageList(Page<ProjectVo> page, ProjectQueryDto queryDto) {
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(" p.id, p.topic_id,  p.status,  p.start_date, p.end_date",
                        "   s.id AS student_id,  s.username AS student_username,  si.name AS student_name,   si.gender AS student_gender, ",
                        " t.id AS teacher_id, t.username AS teacher_username,  ti.name AS teacher_name, ti.gender AS teacher_gender ")
                .eq("p.deleted", 0)
                .gt(queryDto.getStartDate()!=null,"p.start_date",queryDto.getStartDate())
                .lt(queryDto.getEndDate()!=null,"p.start_date",queryDto.getEndDate())
                .orderByDesc("p.id");
       return projectMapper.selectProjectPage(page, queryWrapper);

    }
}




