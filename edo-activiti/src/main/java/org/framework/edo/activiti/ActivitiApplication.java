package org.framework.edo.activiti;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * 流程启动类
 *
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-06-07 15:35
 * @Version 1.0
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ActivitiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActivitiApplication.class,args);
    }
}
