package org.framework.edo.jdk.jvm;

/**
 *
 * 引用计数算法的缺陷
 *
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-11-01 16:57
 * @Version 1.0
 */

public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1M = 1024*1024;
    /**
     * 占点内存，以便在gc日志中看清楚是否被回收
     */
    private byte[] bigSize = new byte[2*_1M];

    /**
     * -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps
     * @param args
     */
    public static void main(String[] args) {
        ReferenceCountingGC gc1 = new ReferenceCountingGC();
        ReferenceCountingGC gc2 = new ReferenceCountingGC();
        gc1.instance = gc2;
        gc2.instance = gc1;
        gc1 = null;
        gc2 = null;
        System.gc();
    }
}
