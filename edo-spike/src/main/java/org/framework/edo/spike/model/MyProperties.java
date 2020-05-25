package org.framework.edo.spike.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration //自定义配置类  也可使用@Component注解
@PropertySource("classpath:test/test.properties")//指定自定义配置文件位置和名称
@EnableConfigurationProperties(MyProperties.class) //开启对应配置类的属性注入功能
@ConfigurationProperties(prefix = "test") //设置配置类前缀
@Data
public class MyProperties {
    private int id;
    private String name;
}
