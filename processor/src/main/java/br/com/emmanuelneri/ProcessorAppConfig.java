package br.com.emmanuelneri;

import br.com.emmanuelneri.app.notafiscal.repository.NotaFiscalRepository;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import br.com.emmanuelneri.app.ArquivoNotaFiscalConsumer;
import br.com.emmanuelneri.app.notafiscal.model.NotaFiscal;

import javax.jms.Queue;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackageClasses = {ArquivoNotaFiscalConsumer.class})
@EntityScan(basePackageClasses = {NotaFiscal.class, Jsr310JpaConverters.class})
@EnableJpaRepositories(basePackageClasses = {NotaFiscalRepository.class})
@EnableJms
public class ProcessorAppConfig {

    @Value("${queue.process.name}")
    private String fileProcessQueue;

    @Value("${queue.error.name}")
    private String fileErrorQueue;

    public static void main(String[] args) {
        SpringApplication.run(ProcessorAppConfig.class, args);
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(fileProcessQueue);
    }
}
