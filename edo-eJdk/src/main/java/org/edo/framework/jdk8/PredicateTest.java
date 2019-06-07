package org.edo.framework.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-05-29 11:03
 * @Version 1.0
 */

public class PredicateTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("");
        list.add("1");
        list.add("2");
        list.add(" ");
        list.add(" 3 ");
        list.add(null);

        //注意null 的顺序
        Predicate<String> predicate = (String s) -> s == null || s.trim().length() <= 0;
        List resultList = filterString(list, predicate);
        System.out.println("-----------exiuqa-----------resultList值=" + resultList + "," + "当前类=PredicateTest.main()");

        List resultList1 = filterMap(Arrays.asList("line", "action", "  "), (String s) -> s.length());
        System.out.println("-----------exiuqa-----------resultList1值=" + resultList1 + "," + "当前类=PredicateTest.main()");

        List resultList2 = filterMap(list, (String s) -> s.length());
        System.out.println("-----------exiuqa-----------resultList2值=" + resultList2 + "," + "当前类=PredicateTest.main()");


    }

    /**
     * 过滤空字符串
     *
     * @param list
     * @param predicate
     * @param <T>
     * @return
     */
    static <T> List<T> filterString(List<T> list, Predicate predicate) {
        List<T> resultList = new ArrayList<>();
        for (T t : list) {
            if (!predicate.test(t)) {
                resultList.add(t);
            }
        }
        return resultList;
    }

    static <T, R> List<R> filterMap(List<T> list, Function<T, R> function) {
        List<R> resultList = new ArrayList<>();
        for (T t : list) {
            if (t != null) {
                resultList.add(function.apply(t));
            }
        }
        return resultList;
    }
}
