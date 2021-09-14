package oki.test.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OkiBackupApplication {

    public static void main(String[] args) {
        SpringApplication.run(OkiBackupApplication.class, args);
    }

}
