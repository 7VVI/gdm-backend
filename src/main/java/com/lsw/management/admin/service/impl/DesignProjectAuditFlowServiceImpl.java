package com.lsw.management.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsw.management.admin.mapper.DesignProjectAuditFlowMapper;
import com.lsw.management.admin.model.dto.designProjectAuditFlow.DesignProjectAuditFlowAddDto;
import com.lsw.management.admin.model.dto.designProjectAuditFlow.DesignProjectAuditFlowQueryDto;
import com.lsw.management.admin.model.dto.designProjectAuditFlow.DesignProjectAuditFlowUpdateDto;
import com.lsw.management.admin.model.po.DesignProjectAuditFlow;
import com.lsw.management.admin.model.po.UserAccount;
import com.lsw.management.admin.model.vo.designProjectAuditFlow.DesignProjectAuditFlowVO;
import com.lsw.management.admin.service.DesignProjectAuditFlowService;
import com.lsw.management.admin.service.UserAccountService;
import com.lsw.management.common.constants.ErrorCode;
import com.lsw.management.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author lsw
 * @Date 2023/4/6 15:25
 * @desc
 */
@Service
public class DesignProjectAuditFlowServiceImpl extends ServiceImpl<DesignProjectAuditFlowMapper, DesignProjectAuditFlow>
        implements DesignProjectAuditFlowService {

    @Resource
    private UserAccountService userAccountService;

    @Resource
    private DesignProjectAuditFlowMapper designProjectAuditFlowMapper;

    @Override
    public Integer designProjectAuditFlowAdd(DesignProjectAuditFlowAddDto auditFlowAddDto, HttpServletRequest request) {
        DesignProjectAuditFlow designProjectAuditFlow = new DesignProjectAuditFlow();
        BeanUtils.copyProperties(auditFlowAddDto, designProjectAuditFlow);
        designProjectAuditFlow.setDepartmentAuditTime(new Date());
        UserAccount currentUser = userAccountService.getCurrentUser(request);
        if (currentUser.getId() == null) {
            throw new BusinessException(ErrorCode.UNLOGIN);
        }
        designProjectAuditFlow.setDepartmentAuditUserId(currentUser.getId());
        return designProjectAuditFlowMapper.insert(designProjectAuditFlow);
    }

    @Override
    public Integer designProjectAuditFlowDelete(String ids) {
        if (StringUtils.isBlank(ids)) {
            throw new BusinessException(ErrorCode.INVALID_PARAMS);
        }
        String[] id = ids.split(",");
        return designProjectAuditFlowMapper.deleteBatchIds(Arrays.asList(id));
    }

    @Override
    public Integer designProjectAuditFlowUpdate(DesignProjectAuditFlowUpdateDto updateDto, HttpServletRequest request) {
        DesignProjectAuditFlow designProjectAuditFlow = new DesignProjectAuditFlow();
        BeanUtils.copyProperties(updateDto, designProjectAuditFlow);
        designProjectAuditFlow.setSchoolAuditTime(new Date());
        UserAccount currentUser = userAccountService.getCurrentUser(request);
        if (currentUser.getId() == null) {
            throw new BusinessException(ErrorCode.UNLOGIN);
        }
        designProjectAuditFlow.setSchoolAuditUserId(currentUser.getId());
        return designProjectAuditFlowMapper.updateById(designProjectAuditFlow);
    }

    @Override
    public List<DesignProjectAuditFlowVO> announcementPageList(Page<DesignProjectAuditFlowVO> page, DesignProjectAuditFlowQueryDto queryDto) {
        QueryWrapper<DesignProjectAuditFlow> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("            d.id," +
                        "            d.department_audit_result," +
                        "            d.department_audit_user_id," +
                        "            d.school_audit_time," +
                        "            d.school_audit_result," +
                        "            d.school_audit_user_id,d.school_audit_user_opinion" +
                        "            d.department_audit_time,d.department_audit_opinion" +
                        "            t.title")

                .orderByDesc("d.id");
        return designProjectAuditFlowMapper.selectPageList(page, queryWrapper);
    }
}




