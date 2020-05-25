package org.framework.edo.spike.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {

    @Autowired
    private Student student;

    @Test
    public void testPerson() {
        System.out.println(student);
    }

}
