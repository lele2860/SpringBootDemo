package oki.test.admin.controller;

import oki.test.admin.domain.SysDept;
import oki.test.admin.services.SysDeptService;
import oki.test.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dept")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    @PostMapping(value="/save")
    public HttpResult save(@RequestBody SysDept record) {
        return HttpResult.ok(sysDeptService.save(record));
    }

    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysDept> records) {
        return HttpResult.ok(sysDeptService.delete(records));
    }

    @GetMapping(value="/findTree")
    public HttpResult findTree() {
        return HttpResult.ok(sysDeptService.findTree());
    }

}
