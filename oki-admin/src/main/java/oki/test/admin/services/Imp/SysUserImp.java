package oki.test.admin.services.Imp;


import oki.test.admin.dao.SysUserMapper;
import oki.test.admin.domain.SysMenu;
import oki.test.admin.domain.SysUser;
import oki.test.admin.domain.SysUserRole;
import oki.test.admin.services.SysMenuService;
import oki.test.admin.services.SysUserService;
import oki.test.core.http.HttpResult;
import oki.test.core.page.MybatisPageHelper;
import oki.test.core.page.PageRequest;
import oki.test.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysUserImp implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }

    @Override
    public int save(SysUser record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysUserMapper.insertSelective(record);
        }
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysUser record) {
        return sysUserMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysUser> records) {

        for(SysUser needDeleteSysUser:records){
            sysUserMapper.deleteByPrimaryKey(needDeleteSysUser.getId());
        }
        return 1;
    }


    @Override
    public SysUser findById(Long id) {
        return  sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest,sysUserMapper);
    }

    @Override
    public SysUser findByName(String name) {
        return sysUserMapper.findByName(name);
    }

    //非自我实现
    @Override
    public Set<String> findPermissions(String userName) {
        Set<String> perms = new HashSet<>();
        List<SysMenu> sysMenus = sysMenuService.findByUser(userName);
        for(SysMenu sysMenu:sysMenus) {
            if(sysMenu.getPerms() != null && !"".equals(sysMenu.getPerms())) {
                perms.add(sysMenu.getPerms());
            }
        }
        return perms;
    }

    @Override
    public List<SysUserRole> findUserRoles(Long userId) {
        return null;
    }

    @Override
    public File createUserExcelFile(PageRequest pageRequest) {
        return null;
    }
}
