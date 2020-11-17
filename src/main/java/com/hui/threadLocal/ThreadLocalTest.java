package com.hui.threadLocal;

/**
 * @Author: menglh
 * @Description:
 * @Date: 2020/11/16 21:53
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        Account at = new Account("初始名");

        new MyTest(at,"线程甲").start();//注意区分线程名和账户名
        new MyTest(at,"线程乙").start();


    }
}
