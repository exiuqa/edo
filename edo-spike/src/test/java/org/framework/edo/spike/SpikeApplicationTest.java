package org.framework.edo.spike;

import org.framework.edo.spike.model.User;
import org.framework.edo.spike.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpikeApplicationTest {
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        User user = userService.selectByPrimaryKey("1");
        System.out.println(user);
    }
}
