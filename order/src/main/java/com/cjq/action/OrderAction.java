package com.cjq.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cjq
 * @date 2020/8/12
 */
@RestController
public class OrderAction {

    @RequestMapping("/queryUser")
    public String queryUser() {
        System.out.println("========micro-order===queryUser");
        return "========cjq-order===queryUser";
    }
}
