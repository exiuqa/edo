package org.framework.edo.concurrent.api;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-05-19 11:53
 * @Version 1.0
 */

public class MultiThread {
    public static void main(String[] args) {
        mainThread();
    }

    /**
     * [5]:Monitor Ctrl-Break
     * [4]:Signal Dispatcher 分发处理发送给jvm信号的线程
     * [3]:Finalizer  调用对象finalize方法的线程
     * [2]:Reference Handler 清除Reference的线程
     * [1]:main
     */
    static void mainThread() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + ":" + threadInfo.getThreadName());
        }
    }
}
