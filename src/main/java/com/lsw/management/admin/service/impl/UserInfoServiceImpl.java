package com.lsw.management.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsw.management.admin.mapper.UserInfoMapper;
import com.lsw.management.admin.model.po.UserInfo;
import com.lsw.management.admin.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author lsw
 * @Date 2023/4/7 12:21
 * @desc
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
}
