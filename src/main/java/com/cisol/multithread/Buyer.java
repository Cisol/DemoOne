package com.cisol.multithread;

/**
 * Created by Zhangm on 2017/4/6 0006.
 */
public class Buyer extends Thread {
    private BookStore bookStore;

    public Buyer(BookStore bookStore) {
        this.bookStore = bookStore;
    }

    @Override
    public void run() {
        while (true) {
            bookStore.removeBook();
        }
    }
}
