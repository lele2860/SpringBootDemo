package oki.test.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class OkiMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OkiMonitorApplication.class, args);
    }

}
