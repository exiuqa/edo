package org.framework.edo.jdk.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * JAVA堆内存溢出异常测试
 *
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-11-01 15:22
 * @Version 1.0
 */

public class HeapOOM {

    static class OOMObject{

    }

    /**
     * vm args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     * @param args
     */
    public static void main(String[] args) {
     List<OOMObject> list = new ArrayList<>();
     while (true){
         list.add(new OOMObject());
     }
    }
}
