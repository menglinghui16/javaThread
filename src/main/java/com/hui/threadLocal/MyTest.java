package com.hui.threadLocal;

/**
 * @Author: menglh
 * @Description:
 * @Date: 2020/11/16 21:53
 */
public class MyTest extends Thread {
    private Account account;

    public MyTest(Account account, String name) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i == 6) {
                account.setName(getName());//这里的getName()是Thread中的获取线程名的方法，不是account中的方法
            }
            System.out.println(account.getName() + "账户的i值：" + i);
        }

    }
}
