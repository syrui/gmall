package com.gmall.filter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by syr on 2020/7/12
 */
@Configuration
class RouteConfiguration {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {

        return builder.routes().route(r ->
                r.path("/manageService/**")
                        .uri("lb://gmall-manage-service")
                        .filter(new TokenGatewayFilter())
                        .id("gmallManage"))
                .build();
    }

}