package oki.test.admin.services;

import oki.test.admin.domain.SysDict;
import oki.test.core.service.CurdService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDictService extends CurdService<SysDict> {

    List<SysDict> findByLabel(@Param(value = "label") String label);

}
