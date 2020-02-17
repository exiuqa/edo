package org.framework.edo.jdk.collection;

import java.util.List;

public class ArrayList {
    public static void main(String[] args) {
        List<Object> list = new java.util.ArrayList();
        list.add(null);
        System.out.println("-----------exiuqa-----------list值=" + list + "," + "当前类=EdoList.main()");


        int i = 10;
        i = 10 << 2;
        System.out.println("-----------exiuqa-----------i值=" + i + "," + "当前类=EdoList.main()");
    }
}
