package com.cisol.algorithm;

import java.util.Vector;

/**
 * Created by Administrator on 2016/9/30 0030.
 */
public class StringMatcher {

    public static void main(String[] args) {
        String s = "bestg@oodfineneedapartofgoodbestfinesunshine";
        Long l1 = 1L;
        Long l2 = 1L;
        boolean b = l1.equals(l2);
        System.out.println(b);
    }

    public static void findSubString(String s, Vector<String> v) {
        int size = v.size();
        if(size == 0)
            return;
        int length = v.get(0).length() * size;

    }

}
