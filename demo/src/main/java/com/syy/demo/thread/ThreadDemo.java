package com.syy.demo.thread;

public class ThreadDemo {
    public static void main(String[] args) {
        RunnableThread runnableThread = new RunnableThread();
//		runnableThread.run();
//		runnableThread.run();
//		runnableThread.run();
//		runnableThread.run();
        new Thread(runnableThread).start();
        new Thread(runnableThread).start();
        new Thread(runnableThread).start();
        new Thread(runnableThread).start();

        ThreadThread tt = new ThreadThread();
        tt.start();//起一个线程执行
        tt.run();//在当前线程里执行
        
    }
}

class RunnableThread implements Runnable {

    private int count = 10;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (count > 0) {
            System.out.println(Thread.currentThread().getName() + "-------" + count--);
        }
    }

}

class ThreadThread extends Thread {
    private int count = 10;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (count > 0) {
            System.out.println(Thread.currentThread().getName() + "******" + count--);
        }
    }
}

