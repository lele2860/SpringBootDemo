package oki.test.admin.controller;



import oki.test.admin.services.Imp.SysUserImp;
import oki.test.core.http.HttpResult;
import oki.test.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class SysUserController {

    @Autowired
    private SysUserImp sysUserImp;


    @GetMapping("/findAll")
    public Object findAll(){
        return sysUserImp.findAll();
    }

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageReuest){
        return HttpResult.ok(sysUserImp.findPage(pageReuest));
    }

    @GetMapping("/findByName")
    public Object findByName(@RequestParam String name){
        return sysUserImp.findByName(name);
    }

}
