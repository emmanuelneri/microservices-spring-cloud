package br.com.emmanuelneri.receiver;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RefreshScope
@ConfigurationProperties
@Getter
public class FeaturesProperties {

    @Value("#{'${feature.order.api.origins}'.split(',')}")
    private List<String> origins;

}
