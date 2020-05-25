package org.framework.edo.spike.controller;

import org.framework.edo.spike.model.User;
import org.framework.edo.spike.result.Result;
import org.framework.edo.spike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/helloo")
    public String hello() {
        return "hello spike";
    }

    @RequestMapping("/in")
    public Result in() {
        User user = userService.selectByPrimaryKey("1");
        return Result.success(user);
    }

    @RequestMapping("/out")
    public Result out(@RequestBody User user) {
        return Result.success(user);
    }
}
