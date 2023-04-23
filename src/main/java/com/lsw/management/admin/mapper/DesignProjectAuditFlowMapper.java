package com.lsw.management.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsw.management.admin.model.po.DesignProjectAuditFlow;
import com.lsw.management.admin.model.vo.designProjectAuditFlow.DesignProjectAuditFlowVO;

import java.util.List;

/**
* @author 17533
* @description 针对表【design_project_audit_flow】的数据库操作Mapper
* @createDate 2023-04-22 11:03:16
* @Entity generator.domain.DesignProjectAuditFlow
*/
public interface DesignProjectAuditFlowMapper extends BaseMapper<DesignProjectAuditFlow> {

    /**
     * 分页查询
     * @param page /
     * @param queryWrapper /
     * @return /
     */
    List<DesignProjectAuditFlowVO> selectPageList(Page<DesignProjectAuditFlowVO> page, QueryWrapper<DesignProjectAuditFlow> queryWrapper);
}




