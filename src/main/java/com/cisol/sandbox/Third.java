package com.cisol.sandbox;

import java.security.KeyStore;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Administrator on 2017/7/6 0006.
 */
public class Third {
    public static void main(String[] args) {
        int num;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        HashMap<String, Integer> callTime = new HashMap<String, Integer>();
        String[][] call = new String[num][num];
        if(num <= 0)
            return;
        for(int i = 0; i < num; i++) {
            String s = scanner.nextLine();
            String[] ss = s.split(" ");
            for(int j = 0; j < 2; j++) {
                call[i][j] = ss[j];
                if(callTime.containsKey("str")) {
                    callTime.put("str", callTime.get("str") + 1);
                } else {
                    callTime.put("str", 0);
                }
            }
        }
        if(topoSort(callTime, call)) {
            System.out.println("no");
        } else {
            System.out.print("yes");
        }
    }

    public static boolean topoSort(HashMap<String, Integer> callTime, String[][] call) {
        String key;
        for (Map.Entry<String, Integer> entry : callTime.entrySet()) {
            if (entry.getValue() == 0) {
                key = entry.getKey();
                for(int i = 0; i < call.length; i++) {
                    if(call[i][0] == key)
                        callTime.put(call[i][1], callTime.get(call[i][1]) - 1);
                }
                callTime.remove(key);
            }
        }
        if (callTime.isEmpty())
            return true;
        return false;
    }
}
