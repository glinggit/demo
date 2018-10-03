package com.syy.demo.utils.redis;

import redis.clients.jedis.Jedis;

public class RedisUtilsTest {
	public static void main(String[] args) {
		Jedis jedis = RedisUtils.getJedis();
		/**
		 * 对字符的操作
		 */
		// -----添加数据----------
//		jedis.set("name", "xinxin");// 向key-->name中放入了value-->xinxin
//		System.out.println(jedis.get("name"));// 执行结果：xinxin
//
//		jedis.append("name", " is my lover"); // 拼接 。
//		// 如果用redis命令输入key对应的值是不能有空格的哦
//		System.out.println(jedis.get("name"));
//
//		jedis.del("name"); // 删除某个键
//		System.out.println(jedis.get("name"));
//		// 设置多个键值对
//		jedis.mset("name", "liuling", "age", "11");
//		jedis.incr("age"); // 进行加1操作
//		
//		jedis.set("china", "这是个中文值");
//		System.out.println(jedis.get("china"));
		jedis.set("china", "这是个中文值");
		jedis.expire("china", 30);
		

		
		RedisUtils.returnResource(jedis);
	}
}
