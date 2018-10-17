package com.syy.demo.thread1;

public class Consumer implements Runnable {
	private Storage resource;

	public Consumer(Storage resource) {
		super();
		this.resource = resource;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			resource.cosume();
		}
	}
}
