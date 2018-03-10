package br.com.emmanuelneri;

import br.com.emmanuelneri.processor.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.amqp.Amqp;
import org.springframework.integration.dsl.support.Transformers;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = "br.com.emmanuelneri.processor.order.model", basePackageClasses = Jsr310JpaConverters.class)
@EnableIntegration
public class ProcessorAppConfig {

    @Autowired
    private RabbitConfig rabbitConfig;

    public static void main(String[] args) {
        SpringApplication.run(ProcessorAppConfig.class, args);
    }

    @Bean
    public IntegrationFlow orderProcessorFlow() {
        return IntegrationFlows
                .from(Amqp.inboundAdapter(rabbitConfig.listenerContainer()))
                .transform(Transformers.fromJson(Order.class))
                .handle("orderProcessService", "process")
                .get();
    }
}
