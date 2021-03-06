package com.ribbon.config;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.netflix.ribbon.RibbonClientName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* 这个类最好不要出现在启动类的@ComponentScan扫描范围
* 如果出现在@ComponentScan扫描访问，那么这个配置类就是每个服务共用的配置了
* */
@Configuration
public class RibbonLoadBalanceMicroOrderConfig {

    @RibbonClientName
    private final String name = "cjq-order";

    @Bean
    @ConditionalOnClass
    public IClientConfig defaultClientConfigImpl() {
        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
        config.loadProperties(name);
        config.set(CommonClientConfigKey.MaxAutoRetries,3);
        config.set(CommonClientConfigKey.MaxAutoRetriesNextServer,3);
        config.set(CommonClientConfigKey.ConnectTimeout,1000);
        config.set(CommonClientConfigKey.ReadTimeout,3000);
        config.set(CommonClientConfigKey.OkToRetryOnAllOperations,true);
        return config;
    }
    /*
    * 判断服务是否存活
    * */
    @Bean
    public IPing iPing() {
        //这个实现类会去调用服务来判断服务是否存活
        PingUrl pingUrl = new PingUrl();
        //无效链接
        //pingUrl.setPingAppendString("/user/queryContent");
        //有效链接
        pingUrl.setPingAppendString("/queryUser");
        return pingUrl;
        //最好直接返回，否则会拉长接口调用响应时间
        //return new NoOpPing();
    }

    @Bean
    public IRule ribbonRule() {
        //线性轮训
        new RoundRobinRule();
        //可以重试的轮训
        new RetryRule();
        //根据运行情况来计算权重
        new WeightedResponseTimeRule();
        //过滤掉故障实例，选择请求数最小的实例
        new BestAvailableRule();
        //随机
        return new RandomRule();
    }
}
