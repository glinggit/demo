package com.syy.demo.thread;

public class ThreadSubMain {
	public static void main(String[] args) {
		final MyThread mt = new MyThread();

		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 50; i++) {
					mt.subThread(i);
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 50; i++) {
					mt.mainThread(i);
				}
			}
		}).start();

	}

}

class MyThread {
	boolean flag = false;

	public synchronized void subThread(int i) {
		if (flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 0; j < 10; j++) {
			System.out.println("sub" + i);
		}
		flag = true;
		this.notify();
	}

	public synchronized void mainThread(int i) {
		if (!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 0; j < 10; j++) {
			System.out.println("main" + i);
		}
		flag = false;
		this.notify();
	}
}
