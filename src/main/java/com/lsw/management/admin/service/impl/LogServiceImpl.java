package com.lsw.management.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsw.management.admin.mapper.LogMapper;
import com.lsw.management.admin.model.dto.log.SysLogQueryDto;
import com.lsw.management.admin.model.po.SysLog;
import com.lsw.management.admin.model.vo.log.SysLogVo;
import com.lsw.management.admin.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lsw
 * @Date 2023/4/7 16:44
 * @desc 系统日志查询
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, SysLog> implements LogService {
    @Resource
    LogMapper logMapper;

    @Override
    public List<SysLogVo> pageList(Page<SysLogVo> page, SysLogQueryDto queryDto) {

        QueryWrapper<SysLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("sys_log.id,sys_log.level,sys_log.business_type,sys_log.request_method,sys_log.oper_name," +
                        "sys_log.oper_time,sys_log.oper_ip,sys_log.oper_url,sys_log.exception_detail")
                .eq(queryDto.getLevel()!=null,"sys_log.level", queryDto.getLevel())
                .eq(queryDto.getBusinessType()!=null,"sys_log.business_type", queryDto.getBusinessType())
                .eq(queryDto.getRequestMethod()!=null,"sys_log.request_method", queryDto.getRequestMethod())
                .eq(queryDto.getOperUrl()!=null,"sys_log.oper_url", queryDto.getOperUrl())
                .eq(queryDto.getOperIp()!=null,"sys_log.oper_ip", queryDto.getOperIp())
                .eq(queryDto.getOperTime()!=null,"sys_log.oper_time", queryDto.getOperTime())
                .orderByDesc("sys_log.create_time");
        return logMapper.selecSysLogPage(page, queryWrapper);
    }
}
