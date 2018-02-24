package br.com.emmanuelneri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FilesApiAppConfig {

    public static void main(String[] args) {
        SpringApplication.run(FilesApiAppConfig.class, args);
    }
}
