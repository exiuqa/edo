package org.framework.edo.spike.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Data
@ConfigurationProperties(prefix = "person")
public class Person {
    private int id;
    private String name;
    private List hobby;
    private String[] family;
    private Map map;
    private Pet pet;
}
