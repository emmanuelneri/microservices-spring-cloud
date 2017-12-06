package br.com.emmanuelneri;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan
@EnableJpaRepositories
@EnableJms
public class ProcessorAppConfig {

    @Value("${queue.error.name}")
    private String fileErrorQueue;

    public static void main(String[] args) {
        SpringApplication.run(ProcessorAppConfig.class, args);
    }

    @Bean
    public Queue errorQueue() {
        return new ActiveMQQueue(fileErrorQueue);
    }
}
