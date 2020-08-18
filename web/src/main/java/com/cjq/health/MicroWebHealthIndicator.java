package com.cjq.health;

import com.cjq.action.UserAction;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义健康检测
 */
@Configuration
public class MicroWebHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        if(UserAction.canVisitDb) {
            //可以访问db，返回UP，表示服务可用
            return new Health.Builder(Status.UP).build();
        } else {
            //返回DOWN，表示服务不可用
            return new Health.Builder(Status.DOWN).build();
        }
    }
}
