package br.com.emmanuelneri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = "br.com.emmanuelneri.orders.model", basePackageClasses = Jsr310JpaConverters.class)
@EnableFeignClients
public class OrdersApiAppConfig {

    public static void main(String[] args) {
        SpringApplication.run(OrdersApiAppConfig.class, args);
    }

}
