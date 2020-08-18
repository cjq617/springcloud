package com.cjq.service.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "MICRO-ORDER")
public interface TeacherServiceFeign /*extends TeacherService*/ {
}
