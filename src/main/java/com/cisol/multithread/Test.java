package com.cisol.multithread;

import com.cisol.multithread.BookStore;
import com.cisol.multithread.Buyer;
import com.cisol.multithread.Seller;

/**
 * Created by Zhangm on 2017/4/6 0006.
 */
public class Test {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        Buyer[] buyers = new Buyer[10];
        Seller[] sellers = new Seller[10];
        for (int i = 0; i < 10; i++) {
            buyers[i] = new Buyer(bookStore);
            sellers[i] = new Seller(bookStore);
            buyers[i].start();
            sellers[i].start();
        }
    }
}
