package com.cisol.multithread;

/**
 * Created by Zhangm on 2017/4/6 0006.
 */
public class Seller extends Thread {
    private BookStore bookStore;
    public Seller(BookStore bookStore) {
        this.bookStore = bookStore;
    }

    @Override
    public void run() {
        while (true) {
            bookStore.addBook();
        }
    }
}
