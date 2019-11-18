package org.framework.edo.jdk.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *
 * 方法区出现内存溢出异常
 *
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-11-01 16:06
 * @Version 1.0
 */

public class JavaMethodAreaOOM {
    /**
     * vm args: -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
     *
     * JDK8中用metaspace代替permsize;   将-XX:PermSize=200m -XX:MaxPermSize=256m
     *                                修改为：-XX:MetaspaceSize=200m -XX:MaxMetaspaceSize=256m
     * @param args
     */
    public static void main(String[] args) {
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,objects);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject{

    }
}
