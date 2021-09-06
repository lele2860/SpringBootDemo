package oki.test.admin.dao;

import oki.test.admin.domain.SysConfig;

public interface SysConfigMapper {
    int insert(SysConfig record);

    int insertSelective(SysConfig record);
}