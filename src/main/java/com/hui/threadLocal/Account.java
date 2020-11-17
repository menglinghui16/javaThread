package com.hui.threadLocal;

/**
 * @Author: menglh
 * @Description:
 * @Date: 2020/11/16 21:52
 */
public class Account {
    private ThreadLocal<String> name = new ThreadLocal<String>();

    public Account(String str) {
        this.name.set(str);
        System.out.println("---"+this.name.get());
    }

    public String getName() {
        return name.get();
    }

    public void setName(String str) {
        this.name.set(str);
    }
}
