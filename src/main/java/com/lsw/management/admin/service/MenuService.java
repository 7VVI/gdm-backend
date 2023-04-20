package com.lsw.management.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsw.management.admin.model.dto.menu.MenuAddDto;
import com.lsw.management.admin.model.dto.menu.MenuUpdateDto;
import com.lsw.management.admin.model.po.Menu;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lsw
 * @Date 2023/4/7 12:17
 * @desc
 */

public interface MenuService extends IService<Menu> {

    /**
     * 根据权限获取对应菜单
     * @param permissions 权限
     * @return 对应权限菜单
     */
    List<Menu> listAll(String permissions);

    /**
     * 添加菜单
     *
     * @param addDto /
     * @return /
     */
    Integer add(MenuAddDto addDto, HttpServletRequest request);

    /**
     * 删除菜单
     * @param ids 多个菜单使用逗号分割 如1，2
     * @return /
     */
    Integer delete(String ids);

    /**
     * 更新菜单信息
     * @param updateDto /
     * @return /
     */
    Integer update(MenuUpdateDto updateDto,HttpServletRequest request);
}
