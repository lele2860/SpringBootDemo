package oki.test.admin.controller;

import oki.test.admin.domain.SysLoginLog;
import oki.test.admin.services.SysLoginLogService;
import oki.test.core.http.HttpResult;
import oki.test.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("loginlog")
public class SysLoginLogController {
    @Autowired
    private SysLoginLogService sysLoginLogService;

    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLoginLogService.findPage(pageRequest));
    }

    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysLoginLog> records) {
        return HttpResult.ok(sysLoginLogService.delete(records));
    }
}
