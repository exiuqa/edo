package org.framework.edo.jdk.jvm;

/**
 *
 * 虚拟机栈和本地方法栈OOM测试
 *
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-11-01 15:38
 * @Version 1.0
 */

public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    /**
     * vm args: -Xss128k
     * @param args
     *
     * Error: Could not create the Java Virtual Machine.
     * The stack size specified is too small, Specify at least 160k
     * Error: A fatal exception has occurred. Program will exit.
     */
    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:"+javaVMStackSOF.stackLength);
            throw e;

        }
    }
}
