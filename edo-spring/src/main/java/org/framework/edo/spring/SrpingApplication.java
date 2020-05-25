package org.framework.edo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 启动器
 *
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-05-18 18:40
 * @Version 1.0
 */
@SpringBootApplication
public class SrpingApplication {
    public static void main(String[] args) {
        SpringApplication.run(SrpingApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
