package oki.test.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignHelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/feign/call")
    public String call(){
        return helloService.hello();
    }
}
