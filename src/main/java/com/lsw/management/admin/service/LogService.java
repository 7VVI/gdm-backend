package com.lsw.management.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lsw.management.admin.model.dto.log.SysLogQueryDto;
import com.lsw.management.admin.model.po.SysLog;
import com.lsw.management.admin.model.vo.log.SysLogVo;

import java.util.List;

/**
 * @author lsw
 * @Date 2023/4/7 16:43
 * @desc
 */

public interface LogService extends IService<SysLog> {
    List<SysLogVo> pageList(Page<SysLogVo> page, SysLogQueryDto queryDto);
}
