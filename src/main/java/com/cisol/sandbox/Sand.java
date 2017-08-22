package com.cisol.sandbox;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class Sand {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        //Exception in thread "main" java.lang.NullPointerException
        arrayList.add(null);
        System.out.println(arrayList.size());
    }
}
