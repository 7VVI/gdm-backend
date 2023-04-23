package com.lsw.management.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lsw.management.admin.model.dto.designProjectAuditFlow.DesignProjectAuditFlowAddDto;
import com.lsw.management.admin.model.dto.designProjectAuditFlow.DesignProjectAuditFlowQueryDto;
import com.lsw.management.admin.model.dto.designProjectAuditFlow.DesignProjectAuditFlowUpdateDto;
import com.lsw.management.admin.model.po.DesignProjectAuditFlow;
import com.lsw.management.admin.model.vo.designProjectAuditFlow.DesignProjectAuditFlowVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lsw
 * @Date 2023/4/6 15:25
 * @desc
 */
public interface DesignProjectAuditFlowService extends IService<DesignProjectAuditFlow> {

        Integer designProjectAuditFlowAdd(DesignProjectAuditFlowAddDto auditFlowAddDto, HttpServletRequest request);

        Integer designProjectAuditFlowDelete(String ids);

        Integer designProjectAuditFlowUpdate(DesignProjectAuditFlowUpdateDto updateDto, HttpServletRequest request);

        List<DesignProjectAuditFlowVO> announcementPageList(Page<DesignProjectAuditFlowVO> page, DesignProjectAuditFlowQueryDto queryDto);
}
