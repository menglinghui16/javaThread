package com.hui.thread;

/**
 * Created by Administrator on 2019/9/2.
 */
public class JoinThread extends Thread {
    public JoinThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName()+" "+i);
        }
    }

    public static void main(String[] args) throws Exception {
        JoinThread jt = new JoinThread("新线程");
        jt.start();
        jt.join();
        for (int i = 0; i < 1000; i++) {
//            if(i == 20){
//                JoinThread jt = new JoinThread("被Join的线程");
//                jt.start();
//                jt.join();
//            }
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
