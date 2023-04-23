package com.lsw.management.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsw.management.admin.model.po.SysLog;
import com.lsw.management.admin.model.vo.log.SysLogVo;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * @author lsw
 * @Date 2023/4/6 15:55
 * @desc
 */
public interface LogMapper extends BaseMapper<SysLog> {
    List<SysLogVo> selecSysLogPage(Page<SysLogVo> page, @Param(Constants.WRAPPER)QueryWrapper<SysLog> ew);
}
