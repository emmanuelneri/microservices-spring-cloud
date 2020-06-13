package br.com.emmanuelneri;

import br.com.emmanuelneri.processor.order.components.OrderValidation;
import br.com.emmanuelneri.processor.order.to.OrderTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.handler.LoggingHandler;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = "br.com.emmanuelneri.processor.order.model", basePackageClasses = Jsr310JpaConverters.class)
@EnableIntegration
@EnableFeignClients
public class ProcessorAppConfig {

    @Autowired
    private RabbitConfig rabbitConfig;

    @Autowired
    private OrderValidation orderValidation;

    public static void main(String[] args) {
        SpringApplication.run(ProcessorAppConfig.class, args);
    }

    @Bean
    public IntegrationFlow orderProcessorFlow() {
        return IntegrationFlows
                .from(Amqp.inboundAdapter(rabbitConfig.listenerContainer()))
                .log(LoggingHandler.Level.INFO)
                .transform(Transformers.fromJson(OrderTO.class))
                .filter(orderValidation)
                .handle("orderProcess", "process")
                .get();
    }
}
