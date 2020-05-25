package org.framework.edo.spring.controller;

import org.framework.edo.spring.service.CircularDepAServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述信息：
 * 循环依赖源码调试
 *
 * @author L.Qiang
 * @date 2020/4/23 11:13 AM
 */
@RestController
public class CircularDependenceController {
    @Autowired
    private CircularDepAServiceImpl circularDepAService;


    @GetMapping("/circular")
    public String circular() {
        circularDepAService.circular();
        return "success";
    }
}
