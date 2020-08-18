package com.cjq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author cjq
 * @date 2020/8/12
 */
@SpringBootApplication(scanBasePackages = {"com.cjq"})
//开启Eureka客户端功能
@EnableEurekaClient
//开启断路器功能
@EnableCircuitBreaker
public class WebApplication {

    @Bean
    //ribbon的客户端负载
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
