package com.syy.demo.thread;

public class Consumer extends Thread {
	private String consumer;
	private IStorage storage;

	public Consumer(IStorage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		consume(consumer);
	}

	public void consume(String consumer) {
		storage.consume(consumer);
	}

	public IStorage getStorage() {
		return storage;
	}

	public void setStorage(IStorage storage) {
		this.storage = storage;
	}

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}
}
