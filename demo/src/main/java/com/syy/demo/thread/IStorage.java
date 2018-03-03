package com.syy.demo.thread;

public interface IStorage {
	public void produce(String producer);

	public void consume(String consumer);
}
