package org.framework.edo.spike.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    /**
     * string 作为组件加入容器
     * 组件id默认为方法名
     *
     * @return
     */
    @Bean
    public String myService() {
        return "自定义配置类";
    }
}
