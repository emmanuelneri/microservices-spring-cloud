package br.com.emmanuelneri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigAppConfig {

    public static void main(String[] args) {
        SpringApplication.run(ConfigAppConfig.class, args);
    }

}