package org.framework.edo.jdk.jdk8;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-05-19 16:21
 * @Version 1.0
 */

public class collection {
    public static void main(String[] args) {
        Map<String,Object> requestMap = new HashMap();
        requestMap.put("custNo","11111111");
        System.out.println("-----------exiuqa-----------值=" +  requestMap.get("custNo").toString()+ "," + "当前类=collection.main()");
    }
}
