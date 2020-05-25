package org.framework.edo.jdk.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述信息：
 * stream断点调试
 * https://www.jetbrains.com/help/idea/analyze-java-stream-operations.html
 *
 * @author L.Qiang
 * @date 2020/4/21 7:26 PM
 */
public class PrimeFinder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

//获取每个元素的平方
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
    }
}

