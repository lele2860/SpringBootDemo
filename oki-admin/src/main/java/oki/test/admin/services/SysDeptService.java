package oki.test.admin.services;

import oki.test.admin.domain.SysDept;
import oki.test.core.service.CurdService;

import java.util.List;

public interface SysDeptService extends CurdService<SysDept> {
    /**
     * 查询机构树
     * @param userId
     * @return
     */
    List<SysDept> findTree();
}
