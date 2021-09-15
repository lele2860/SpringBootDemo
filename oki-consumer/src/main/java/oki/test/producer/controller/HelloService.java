package oki.test.producer.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "oki-producer")
public interface HelloService {
    @RequestMapping("/hello")
    public String hello();
}
