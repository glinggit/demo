package com.syy.demo.thread1;

public class Producter implements Runnable {
	private Storage resource;

	public Producter(Storage resource) {
		super();
		this.resource = resource;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			resource.produce();
		}
	}
}
