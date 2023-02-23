package cn.thefronts;

import cn.thefronts.common.lb.annotation.EnableBaseFeignInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chenkun
 * @date 2023/2/2
 */
@EnableFeignClients
@EnableBaseFeignInterceptor
@EnableDiscoveryClient
@SpringBootApplication
public class ThefrontsGatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(ThefrontsGatewayApp.class, args);
    }
}