package br.com.emmanuelneri;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = "br.com.emmanuelneri.processor.order.model", basePackageClasses = Jsr310JpaConverters.class)
@EnableJpaRepositories
@EnableRabbit
public class ProcessorAppConfig {

    public static void main(String[] args) {
        SpringApplication.run(ProcessorAppConfig.class, args);
    }

}
