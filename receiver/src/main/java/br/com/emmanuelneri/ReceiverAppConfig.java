package br.com.emmanuelneri;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;

@SpringBootApplication
@EnableDiscoveryClient
public class ReceiverAppConfig {

    @Value("${queue.name}")
    private String queueName;

    public static void main(String[] args) {
        SpringApplication.run(ReceiverAppConfig.class, args);
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(queueName);
    }

}
