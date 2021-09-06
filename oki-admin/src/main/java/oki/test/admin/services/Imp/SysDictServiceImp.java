package oki.test.admin.services.Imp;

import oki.test.admin.dao.SysDictMapper;
import oki.test.admin.domain.SysDict;
import oki.test.admin.services.SysDictService;
import oki.test.core.page.MybatisPageHelper;
import oki.test.core.page.PageRequest;
import oki.test.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictServiceImp implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public List<SysDict> findByLabel(String label) {
        return sysDictMapper.findByLabel(label);
    }

    @Override
    public int save(SysDict record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysDictMapper.insert(record);
        }
        return sysDictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysDict record) {
        return sysDictMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysDict> records) {
        for (SysDict needDelectSysDict : records) {
            sysDictMapper.deleteByPrimaryKey(needDelectSysDict.getId());
        }
        return 1;
    }

    @Override
    public SysDict findById(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("label");
        if (label != null) {
            return MybatisPageHelper.findPage(pageRequest, sysDictMapper, "findPageByLabel", label);
        }
        return MybatisPageHelper.findPage(pageRequest,sysDictMapper);

    }



}