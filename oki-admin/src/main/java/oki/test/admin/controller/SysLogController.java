package oki.test.admin.controller;

import oki.test.admin.domain.SysLog;
import oki.test.admin.services.SysLogService;
import oki.test.core.http.HttpResult;
import oki.test.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("log")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLogService.findPage(pageRequest));
    }

    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysLog> records) {
        return HttpResult.ok(sysLogService.delete(records));
    }
}
