package org.framework.edo.jdk.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-11-29 12:19
 * @Version 1.0
 */

public class EdoList {
    public static void main(String[] args) {
        List<Object> list = new ArrayList();
        list.add(null);
        System.out.println("-----------exiuqa-----------list值=" + list + "," + "当前类=EdoList.main()");


        int i = 10;
        i = 10 << 2;
        System.out.println("-----------exiuqa-----------i值=" + i + "," + "当前类=EdoList.main()");
    }
}
