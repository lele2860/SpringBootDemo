package oki.test.admin.controller;

import oki.test.admin.domain.SysDict;
import oki.test.admin.services.SysDictService;
import oki.test.core.http.HttpResult;
import oki.test.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dict")
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysDict records){
        return HttpResult.ok(sysDictService.save(records));
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysDict> records){
        return HttpResult.ok(sysDictService.delete(records));
    }

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(sysDictService.findPage(pageRequest));
    }

    @GetMapping(value = "/findByLabel")
    public HttpResult findByLabel(@RequestParam String Label){
        return HttpResult.ok(sysDictService.findByLabel(Label));
    }
}

