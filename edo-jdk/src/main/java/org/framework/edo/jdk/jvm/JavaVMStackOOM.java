package org.framework.edo.jdk.jvm;

/**
 *
 * 创建线程导致内存溢出异常
 *
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-11-01 15:54
 * @Version 1.0
 */

public class JavaVMStackOOM {

    /**
     * vm args: -Xss8m
     * @param args
     */
    public static void main(String[] args) {
        JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
        javaVMStackOOM.stackLeakByThread();
    }

    private void dontstop(){
        while (true){

        }
    }

    public  void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontstop();
                }
            });
            thread.start();
        }
    }
}
