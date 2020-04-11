package ua.lviv.iot.fishing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ua.lviv.iot.fishing.service",
                "ua.lviv.iot.fishing.dataaccess",
                "ua.lviv.iot.fishing.controller"})
@EnableJpaRepositories({"ua.lviv.iot.fishing.dataaccess"})
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

}