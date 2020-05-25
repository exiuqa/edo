package org.framework.edo.leetcode.bitOperation;

import org.junit.Test;

public class Code136Test {

    @Test
    public void singleNumber() {
        int[] arr = new int[]{4, 1, 2, 4, 1, 2, 89};
        Code136 code136 = new Code136();
        int i = code136.singleNumber(arr);
        System.out.println("i = " + i);
    }
}