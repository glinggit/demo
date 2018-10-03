package com.syy.demo.utils.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
    private static String JEDIS_IP;
    private static int JEDIS_PORT;
    private static String JEDIS_PASSWORD;
    private static JedisPool jedisPool;
    static {
        //Configuration自行写的配置文件解析类,继承自Properties
        //Configuration conf=Configuration.getInstance();
        JEDIS_IP="120.78.54.20";//conf.getString("jedis.ip","127.0.0.1");
        JEDIS_PORT=6379;//conf.getInt("jedis.port",6379);
        JEDIS_PASSWORD="redis-syygl1";
        JedisPoolConfig config=new JedisPoolConfig();
        //config.setMaxActive(5000);
        config.setMaxIdle(256);
        //config.setMaxWait(5000L);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        config.setTestWhileIdle(true);
        config.setMinEvictableIdleTimeMillis(60000L);
        config.setTimeBetweenEvictionRunsMillis(3000L);
        config.setNumTestsPerEvictionRun(-1);
        jedisPool=new JedisPool(config,JEDIS_IP,JEDIS_PORT,60000);
    }
    /**
     * 获取Jedis实例
     * @return
     */
    public static Jedis getJedis() {
    	Jedis jedis = jedisPool.getResource();
    	jedis.select(1);
        return jedis;
    }
    /**
     * 获取数据
     * @param key
     * @return
     */
    public static String get(String key){
        String value=null;
        Jedis jedis=null;
        try{
            jedis=getJedis();
            value=jedis.get(key);
        }catch (Exception e){
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        }finally {
            close(jedis);
        }
        return value;
    }

    private static void close(Jedis jedis) {
        try{
            jedisPool.returnResource(jedis);
        }catch (Exception e){
            if(jedis.isConnected()){
                jedis.quit();
                jedis.disconnect();
            }
        }
    }
    public static byte[] get(byte[] key){
        byte[] value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            value = jedis.get(key);
        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }

        return value;
    }

    public static void set(byte[] key, byte[] value) {

        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.set(key, value);
        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }

    public static void set(byte[] key, byte[] value, int time) {

        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.set(key, value);
            jedis.expire(key, time);
        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }

    public static void hset(byte[] key, byte[] field, byte[] value) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.hset(key, field, value);
        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }

    public static void hset(String key, String field, String value) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.hset(key, field, value);
        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }

    /**
     * 获取数据
     *
     * @param key
     * @return
     */
    public static String hget(String key, String field) {

        String value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            value = jedis.hget(key, field);
        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }

        return value;
    }
    /**
     * 获取数据
     *
     * @param key
     * @return
     */
    public static byte[] hget(byte[] key, byte[] field) {

        byte[] value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            value = jedis.hget(key, field);
        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }

        return value;
    }
    public static void hdel(byte[] key, byte[] field) {

        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.hdel(key, field);
        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }
    /**
     * 存储REDIS队列 顺序存储
     * @param  key reids键名
     * @param  value 键值
     */
    public static void lpush(byte[] key, byte[] value) {

        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.lpush(key, value);
        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }

    /**
     * 存储REDIS队列 反向存储
     * @param  key reids键名
     * @param  value 键值
     */
    public static void rpush(byte[] key, byte[] value) {

        Jedis jedis = null;
        try {

            jedis = getJedis();
            jedis.rpush(key, value);

        } catch (Exception e) {

            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {

            //返还到连接池
            close(jedis);

        }
    }

    /**
     * 将列表 source 中的最后一个元素(尾元素)弹出，并返回给客户端
     * @param  key reids键名
     * @param  destination 键值
     */
    public static void rpoplpush(byte[] key, byte[] destination) {

        Jedis jedis = null;
        try {

            jedis = getJedis();
            jedis.rpoplpush(key, destination);

        } catch (Exception e) {

            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {

            //返还到连接池
            close(jedis);

        }
    }

    /**
     * 获取队列数据
     * @param  key 键名
     * @return
     */
    public static List lpopList(byte[] key) {

        List list = null;
        Jedis jedis = null;
        try {

            jedis = getJedis();
            list = jedis.lrange(key, 0, -1);

        } catch (Exception e) {

            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {

            //返还到连接池
            close(jedis);

        }
        return list;
    }
    /**
     * 获取队列数据
     * @param  key 键名
     * @return
     */
    public static byte[] rpop(byte[] key) {

        byte[] bytes = null;
        Jedis jedis = null;
        try {

            jedis = getJedis();
            bytes = jedis.rpop(key);

        } catch (Exception e) {

            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {

            //返还到连接池
            close(jedis);

        }
        return bytes;
    }
    public static void hmset(Object key, Map hash) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.hmset(key.toString(), hash);
        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            //返还到连接池
            close(jedis);

        }
    }
    public static void hmset(Object key, Map hash, int time) {
        Jedis jedis = null;
        try {

            jedis = getJedis();
            jedis.hmset(key.toString(), hash);
            jedis.expire(key.toString(), time);
        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            //返还到连接池
            close(jedis);

        }
    }
    public static List hmget(Object key, String... fields) {
        List result = null;
        Jedis jedis = null;
        try {

            jedis = getJedis();
            result = jedis.hmget(key.toString(), fields);

        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            //返还到连接池
            close(jedis);

        }
        return result;
    }

    public static Set hkeys(String key) {
        Set result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.hkeys(key);

        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            //返还到连接池
            close(jedis);

        }
        return result;
    }
    public static List lrange(byte[] key, int from, int to) {
        List result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.lrange(key, from, to);

        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            //返还到连接池
            close(jedis);

        }
        return result;
    }
    public static Map hgetAll(byte[] key) {
        Map result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.hgetAll(key);
        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            //返还到连接池
            close(jedis);
        }
        return result;
    }

    public static void del(byte[] key) {

        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.del(key);
        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }

    public static long llen(byte[] key) {

        long len = 0;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.llen(key);
        } catch (Exception e) {
            //释放redis对象
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
        return len;
    }
}
