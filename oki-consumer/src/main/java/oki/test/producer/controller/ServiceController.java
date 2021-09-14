package oki.test.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/services")
    public Object services(){
        return discoveryClient.getInstances("oki-producer");
    }

    @RequestMapping("/discover")
    public Object discover(){
        return loadBalancerClient.choose("oki-producer").getUri().toString();
    }
}
