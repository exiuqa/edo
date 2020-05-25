package org.framework.edo.jdk.lang;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述信息：
 * arraylist 测试类
 *
 * @author L.Qiang
 * @date 2020/4/14 3:06 PM
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List list = new ArrayList<>();
    }

    //定义数组
    Person person = new Person(3, "male");
    Person person1 = new Person(3, "male");
    Object[] arr1 = {person, person1};

    static int r = 0, w = 0;

    class Person {
        Person(int age, String gender) {
            this.age = age;
            this.gender = gender;
        }

        private int age;
        private String gender;
    }
}
