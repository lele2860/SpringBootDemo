package oki.test.admin.services;

import oki.test.admin.domain.SysConfig;
import oki.test.core.service.CurdService;

import java.util.List;

public interface SysConfigService extends CurdService<SysConfig> {
    /**
     * 根据名称查询
     * @param lable
     * @return
     */
    List<SysConfig> findByLable(String lable);
}
