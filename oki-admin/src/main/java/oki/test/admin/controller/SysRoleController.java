package oki.test.admin.controller;

import oki.test.admin.constant.SysConstants;
import oki.test.admin.dao.SysRoleMapper;
import oki.test.admin.domain.SysRole;
import oki.test.admin.domain.SysRoleMenu;
import oki.test.admin.services.SysRoleService;
import oki.test.core.http.HttpResult;
import oki.test.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @PostMapping(value="/save")
    public HttpResult save(@RequestBody SysRole record) {
        SysRole role = sysRoleService.findById(record.getId());
        if(role != null) {
            if(SysConstants.ADMIN.equalsIgnoreCase(role.getName())) {
                return HttpResult.error("超级管理员不允许修改!");
            }
        }
        // 新增角色
        if((record.getId() == null || record.getId() ==0) && !sysRoleService.findByName(record.getName()).isEmpty()) {
            return HttpResult.error("角色名已存在!");
        }
        return HttpResult.ok(sysRoleService.save(record));
    }

    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysRole> records) {
        return HttpResult.ok(sysRoleService.delete(records));
    }

    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysRoleService.findPage(pageRequest));
    }

    @GetMapping(value="/findAll")
    public HttpResult findAll() {
        return HttpResult.ok(sysRoleService.findAll());
    }

    @GetMapping(value="/findRoleMenus")
    public HttpResult findRoleMenus(@RequestParam Long roleId) {
        return HttpResult.ok(sysRoleService.findRoleMenus(roleId));
    }

    @PostMapping(value="/saveRoleMenus")
    public HttpResult saveRoleMenus(@RequestBody List<SysRoleMenu> records) {
        for(SysRoleMenu record:records) {
            SysRole sysRole = sysRoleMapper.selectByPrimaryKey(record.getRoleId());
            if(SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
                // 如果是超级管理员，不允许修改
                return HttpResult.error("超级管理员拥有所有菜单权限，不允许修改！");
            }
        }
        return HttpResult.ok(sysRoleService.saveRoleMenus(records));
    }
}
