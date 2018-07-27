package br.com.emmanuelneri;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ReceiverAppConfig {

    @Value("${queue.order.name}")
    private String orderQueue;

    public static void main(String[] args) {
        SpringApplication.run(ReceiverAppConfig.class, args);
    }

    @Bean
    public Queue queue() {
        return new Queue(orderQueue, true);
    }

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

}
