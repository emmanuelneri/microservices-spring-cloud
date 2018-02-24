package br.com.emmanuelneri;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableZuulProxy
public class GatewayAppConfig {

    private static final String ALL = "*";

    @Value("#{'${cors.origins}'.split(',')}")
    private List<String> corsOrigins;

    public static void main(String[] args) {
        SpringApplication.run(GatewayAppConfig.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(corsOrigins);
        config.setAllowedHeaders(Collections.singletonList(ALL));
        config.setAllowedMethods(Collections.singletonList(HttpMethod.GET.name()));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}