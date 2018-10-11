package com.syy.demo.utils.redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
		jedis.expire("china", 300);



		//1、字符串
		jedis.set("a", "aaa");
		System.out.println("连接成功"+jedis.get("a")+"--");

		//2、Hash 对于某些不定项操作可以利用哈希扩展
		jedis.hset("tom", "name", "aa");
		jedis.hset("tom", "age", "12");
		System.out.println(jedis.hmget("tom","age"));
		System.err.println(jedis.hgetAll("tom"));

		//3、List列表


		jedis.lpush("push", "push1");
		jedis.lpush("push", "push2");
		jedis.lpush("push", "push3");
		jedis.lpush("push", "push2");
		// 获取存储的数据并输出
		List<String> list = jedis.lrange("push", 0 ,jedis.llen("push"));
		for(int i=0; i<list.size(); i++) {
			System.out.println("列表项为: "+list.get(i));
		}

		//4、Set 集合 不能添加重复元素
		jedis.sadd("fruit", "苹果","香蕉","橘子");
		jedis.sadd("zoo", "狗", "猫", "猪", "橘子");
		System.out.println(jedis.smembers("friut")+"随机："+jedis.srandmember("friut"));
		//fruit与zoo的交集
		System.out.println("含有相同元素："+jedis.sinter("friut","zoo"));

		//5、有序集合zset
		jedis.zadd("setTest",2,"set2");
		jedis.zadd("setTest",1,"set1");
		jedis.zadd("setTest",3,"set3");
		jedis.zadd("setTest",4,"set4");
		Set<String> set = jedis.zrange("setTest",0,-1);
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}



		

		
		RedisUtils.returnResource(jedis);
	}
}
