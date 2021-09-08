package oki.test.admin.services;


import oki.test.admin.domain.SysUser;

import oki.test.admin.domain.SysUserRole;
import oki.test.core.page.PageRequest;
import oki.test.core.service.CurdService;

import java.io.File;
import java.util.List;
import java.util.Set;

public interface SysUserService extends CurdService<SysUser> {

    List<SysUser> findAll();

    SysUser findByName(String name);




    //非自我实现
    /**
     * 查找用户的菜单权限标识集合
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);

    /**
     * 查找用户的角色集合
     * @param userId
     * @return
     */
    List<SysUserRole> findUserRoles(Long userId);

    /**
     * 生成用户信息Excel文件
     * @param pageRequest 要导出的分页查询参数
     * @return
     */
    File createUserExcelFile(PageRequest pageRequest);

}
