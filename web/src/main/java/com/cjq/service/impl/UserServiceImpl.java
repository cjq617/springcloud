package com.cjq.service.impl;

import com.cjq.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author cjq
 * @date 2020/8/12
 */
@Service
public class UserServiceImpl implements UserService {

    public static final String SERVIER_NAME = "cjq-order";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String queryContents() {

        //通过服务的名称就可以调用
        String results = restTemplate.getForObject("http://"
                + SERVIER_NAME + "/queryUser", String.class);

        return results;
    }

    @HystrixCommand
    @Override
    public String queryTicket() {
        return "query Ticket";
    }
}
