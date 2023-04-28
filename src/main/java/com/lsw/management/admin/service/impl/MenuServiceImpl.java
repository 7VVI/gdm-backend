package com.lsw.management.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsw.management.admin.mapper.MenuMapper;
import com.lsw.management.admin.model.dto.menu.MenuAddDto;
import com.lsw.management.admin.model.dto.menu.MenuUpdateDto;
import com.lsw.management.admin.model.po.Menu;
import com.lsw.management.admin.service.MenuService;
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
import java.util.stream.Collectors;

/**
 * @author lsw
 * @Date 2023/4/6 15:55
 * @desc
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
        implements MenuService {

    @Resource
    MenuMapper menuMapper;

    @Resource
    UserAccountService userAccountService;

    @Override
    public List<Menu> listAll(String permissions) {
        permissions="1,2,3,4";
//        if(StringUtils.isBlank(permissions)){
//            throw new BusinessException(ErrorCode.INVALID_PARAMS);
//        }
        String[] permission = permissions.split(",");
        QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper.eq(Menu.DELETED,0);
        List<Menu> menus = menuMapper.selectList(menuQueryWrapper);
        return menus.stream().filter(e -> {
            String ps = e.getPermissions();
            String[] menuPs = ps.split(",");
            for (String allowedPermission : menuPs) {
                //通过code校验
             if(Arrays.asList(permission).contains(allowedPermission)){
                 return true;
             }
            }
            return false;
        }).collect(Collectors.toList());
    }

    @Override
    public Integer add(MenuAddDto addDto, HttpServletRequest request) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(addDto, menu);
        menu.setCreateBy(userAccountService.getCurrentUser(request).getUsername());
        menu.setCreateTime(new Date());
        return menuMapper.insert(menu);
    }

    @Override
    public Integer delete(String ids) {
        if (StringUtils.isBlank(ids)) {
            throw new BusinessException(ErrorCode.INVALID_PARAMS);
        }
        String[] id = ids.split(",");
        List<Integer> collect = Arrays.stream(id).map(Integer::parseInt).collect(Collectors.toList());
        return menuMapper.deleteBatchIds(collect);

    }

    @Override
    public Integer update(MenuUpdateDto updateDto,HttpServletRequest request) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(updateDto,menu);
        menu.setUpdateBy(userAccountService.getCurrentUser(request).getUsername());
        menu.setUpdateTime(new Date());
     return menuMapper.updateById(menu);
    }
}




