package org.edo.framework.eweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 启动器
 *
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-05-18 18:40
 * @Version 1.0
 */
@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "hello world";
    }
}
