package org.framework.edo.lang;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-05-20 19:11
 * @Version 1.0
 */

public class ObjectTest {
    public static void main(String[] args) {
        Map<String, Person> map = new HashMap<>();
        Person person = new Person("3");
        map.put("age:", person);
        person = new Person("4");
        System.out.println("-----------exiuqa-----------map值=" + map + "," + "当前类=ObjectTest.main()");
        System.out.println("-----------exiuqa-----------person值=" + person + "," + "当前类=ObjectTest.main()");
    }

    static class Person {
        private String age;

        Person(String age) {
            this.age = age;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Person{");
            sb.append("age='").append(age).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
