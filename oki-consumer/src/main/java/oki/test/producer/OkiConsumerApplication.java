package oki.test.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OkiConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OkiConsumerApplication.class, args);
    }

}
