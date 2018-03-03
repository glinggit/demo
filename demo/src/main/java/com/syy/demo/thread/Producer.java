package com.syy.demo.thread;

public class Producer extends Thread {
	private String producer;
	private IStorage storage;

	public Producer(IStorage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		produce(producer);
	}

	public void produce(String producer) {
		storage.produce(producer);
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public IStorage getStorage() {
		return storage;
	}

	public void setStorage(IStorage storage) {
		this.storage = storage;
	}
	
}
