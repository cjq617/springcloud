package com.cjq.action;

import com.cjq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author cjq
 * @date 2020/8/12
 */
@RestController
@RequestMapping("/user")
public class UserAction {

    // 能否访问数据库的标识
    public static boolean canVisitDb = true;

    @Autowired
    private UserService userService;

    @RequestMapping("/queryUser")
    public String queryUser() {
        return userService.queryContents();
    }

    @RequestMapping(value = "/db/{can}", method = RequestMethod.GET)
    @ResponseBody
    public String setDb(@PathVariable boolean can) {
        canVisitDb = can;
        return "200";
    }
}
