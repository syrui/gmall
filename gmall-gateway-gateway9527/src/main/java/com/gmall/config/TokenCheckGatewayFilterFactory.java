package com.gmall.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by syr on 2020/7/12
 */
@Component
public class TokenCheckGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenCheckGatewayFilterFactory.Config> {
    public TokenCheckGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("enabled");
    }
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            System.out.println("这里处理自身逻辑");


            return chain.filter(exchange);
        };

    }

    public static class Config {
        // 控制是否开启认证
        private boolean enabled = true;

        public Config() {}

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}

