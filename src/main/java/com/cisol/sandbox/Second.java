package com.cisol.sandbox;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/6 0006.
 */
public class Second {
    static String baowen = "111#101####0011";
    public static void main(String[] args) {
        int num = 0;
        StringBuffer result = new StringBuffer();
        String s;
        String[] words = baowen.split("#");
        for(String word : words) {
            if (!"".equals(word)) {
                num = Integer.parseInt(word, 2);
                s = int2String(num);
                if (!"".equals(s))
                    result.append(s);
            }
        }
    }
    public static String int2String(int num) {
        //映射表中查找字符
        return "";
    }
}
