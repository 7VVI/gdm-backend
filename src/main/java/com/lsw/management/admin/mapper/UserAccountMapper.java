package com.lsw.management.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsw.management.admin.model.vo.UserVo;
import com.lsw.management.admin.model.po.UserAccount;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * @author lsw
 * @Date 2023/4/6 15:55
 * @desc
 */
public interface UserAccountMapper extends BaseMapper<UserAccount> {

    List<UserVo> selectUserVoPage(Page<UserVo> page, @Param(Constants.WRAPPER) Wrapper<UserAccount> ew);
}
