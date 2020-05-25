package org.framework.edo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CircularDepAServiceImpl {
    @Autowired
    private CircularDepBServiceImpl circularDepBService;

    public void circular() {
        circularDepBService.circular();
        System.out.println("CircularDepAServiceImpl");
    }
}
