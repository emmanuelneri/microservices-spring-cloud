package br.com.emmanuelneri;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.interceptor.RetryInterceptorBuilder;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;

@Configuration
public class RabbitConfig {

    @Value("${queue.order.name}")
    private String orderQueue;

    @Value("${rabbitmq.max.concurrent.consumers}")
    private int maxConcurrentConsumers;

    @Value("${rabbitmq.max.retry.attempts}")
    private int maxRetryAttempts;

    @Autowired
    private ConnectionFactory rabbitConnectionFactory;

    @Bean
    public Queue queue() {
        return new Queue(orderQueue, true);
    }

    @Bean
    public SimpleMessageListenerContainer listenerContainer() {
        final SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(rabbitConnectionFactory);
        container.setQueues(queue());
        container.setMaxConcurrentConsumers(maxConcurrentConsumers);
        container.setDefaultRequeueRejected(false);
        container.setAdviceChain(retryConfig());
        return container;
    }

    private RetryOperationsInterceptor retryConfig() {
        return RetryInterceptorBuilder
                .stateless()
                .maxAttempts(maxRetryAttempts)
                .backOffOptions(1000, 2.0, 10000)
                .build();
    }
}
