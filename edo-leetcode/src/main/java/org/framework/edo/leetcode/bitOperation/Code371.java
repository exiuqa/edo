package org.framework.edo.leetcode.bitOperation;

/**
 * 371. 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 */
public class Code371 {
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;  //注意括号
            System.out.println("a = " + a + ", b = " + b + ",temp=" + temp);
            a = temp;
        }
        return a;
    }
}
