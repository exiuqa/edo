package org.framework.edo.jdk.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 *
 * 本机直接内存溢出
 *
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-11-01 16:30
 * @Version 1.0
 */

public class DirectMemoryOOM {
    /**
     * vm args: -Xmx20m -XX:MaxDirectMemorySize=10m
     * @param args
     */
    private static final int _1M = 1024*1024;
    public static void main(String[] args) throws Exception {
        Field declaredField = Unsafe.class.getDeclaredFields()[0];
        declaredField.setAccessible(true);
        Unsafe unsafe = (Unsafe) declaredField.get(null);
        while (true){
            unsafe.allocateMemory(_1M);
        }
    }
}
