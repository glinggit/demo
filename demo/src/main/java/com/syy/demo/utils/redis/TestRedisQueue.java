package com.syy.demo.utils.redis;

import java.io.IOException;

import com.syy.demo.entity.Message;
import com.syy.demo.utils.ObjectUtil;

public class TestRedisQueue {
	public static byte[] redisKey = "key".getBytes();
	static {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void init() throws IOException {
		for (int i = 0; i < 100; i++) {
			Message message = new Message(i, "这是第" + i + "个内容");
			JedisUtil.lpush(redisKey, ObjectUtil.object2Bytes(message));
		}

	}

	public static void main(String[] args) {
		try {
			for(int i=0; i<88; i++){
				pop();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void pop() throws Exception {
		byte[] bytes = JedisUtil.rpop(redisKey);
		Message msg = (Message) ObjectUtil.bytes2Object(bytes);
		if (msg != null) {
			System.out.println(msg.getId() + "----" + msg.getContent() + "pop");
		}
	}
}
