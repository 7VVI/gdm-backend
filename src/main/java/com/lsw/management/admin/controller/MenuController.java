package com.lsw.management.admin.controller;

import com.lsw.management.admin.model.dto.menu.MenuAddDto;
import com.lsw.management.admin.model.dto.menu.MenuUpdateDto;
import com.lsw.management.admin.model.po.Menu;
import com.lsw.management.admin.service.MenuService;
import com.lsw.management.common.http.response.ApiResponse;
import com.lsw.management.common.http.response.ResponseHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: lsw
 * @desc 系统后端菜单模块
 * @date: 2023/4/19  22:28
 */
@RestController
@RequestMapping("/menuManage")
public class MenuController {

    @Resource
    MenuService menuService;

    @GetMapping("/listAll")
   public ApiResponse<List<Menu>> listAll(@RequestParam(required = false) String permissions){
        return ResponseHelper.success(menuService.listAll(permissions));
    }

    @PostMapping("/add")
    public ApiResponse<Integer>  add(@RequestBody MenuAddDto addDto, HttpServletRequest request){
        return ResponseHelper.success(menuService.add(addDto,request));
    }

    @GetMapping("/delete")
    public ApiResponse<Integer> delete(@RequestParam String ids){
        return ResponseHelper.success(menuService.delete(ids));
    }

    @PostMapping("/update")
    public ApiResponse<Integer> update(@RequestBody MenuUpdateDto updateDto, HttpServletRequest request){
        return ResponseHelper.success(menuService.update(updateDto,request));
    }
}
