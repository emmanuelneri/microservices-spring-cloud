package br.com.emmanuelneri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@EnableDiscoveryClient
@EnableEurekaClient
public class ApiAppConfig {

    public static void main(String[] args) {
        SpringApplication.run(ApiAppConfig.class, args);
    }
}
