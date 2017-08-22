package com.cisol.multithread;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Zhangm on 2017/4/6 0006.
 */
public class BookStore {
    private ArrayList books = new ArrayList();
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

    public void addBook() {
        lock.lock();
        while (books.size() >= 3) {
            try {
                System.out.println(Thread.currentThread().getName() + "等待图书售出");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        books.add(1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "新购入图书：" + books.size());
        condition.signalAll();
        lock.unlock();
    }

    public void removeBook() {
        lock.lock();
        while (books.size() <= 0) {
            try {
                System.out.println(Thread.currentThread().getName() + "等待购入图书");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        books.remove(0);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "售出图书：" + books.size());
        condition.signalAll();
        lock.unlock();
    }
}
