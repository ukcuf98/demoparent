package com.example.demo.cache;

import com.example.demo.DemoUtil;
import com.example.demo.config.ProjConstant;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.cache</p>
 * <p>
 * <p>
 * @author zwq
 * @version 1.0
 * @date 2019/3/26 14:56
 */
@Component
public class RedisCache {


	@Autowired
	private ProjConstant projConstant;

	private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);
	protected JedisSentinelPool jedisPool;
	private GenericObjectPoolConfig config = null;

	private static RedisCache redisCache = new RedisCache();
	public static RedisCache getInstance() {
		return redisCache;
	}

	@PostConstruct
	public void init(){
		try {
			redisCache = this;
			redisCache.projConstant = this.projConstant;

			config = new JedisPoolConfig();
			config.setMaxTotal(8);
			config.setMaxIdle(2);
			config.setMaxWaitMillis(10000);
			config.setTestOnBorrow(true);
			config.setTestOnReturn(true);
			Integer redisOpen = projConstant.getRedisOpen();
			if (redisOpen == 1) {
				/**
				 * 解析各节点
				 */
				String redisConfig = projConstant.getRedisconfig();
				if (StringUtils.isNotBlank(redisConfig)) {
					Set<String> nodes = new HashSet<>();
					String[] nodeArr = redisConfig.split(",");
					for (int i = 0; i < nodeArr.length; i++) {
						String node_tmp = nodeArr[i];
						String[] nodeConfArr = node_tmp.split("-");
						nodes.add(new HostAndPort(nodeConfArr[0], DemoUtil.getIntegerValue(nodeConfArr[1])).toString());
						jedisPool = new JedisSentinelPool(projConstant.getRedisclustername(), nodes, config);
					}
				}
			}
		} catch (Exception ex) {
			config = null;
			jedisPool = null;
			logger.error("BaseRedisCache Static Error: error={}", ex.getMessage(), ex);
		}
	}

	/**
	 * 获取Jedis实例
	 *
	 * @return
	 */
	protected synchronized Jedis getJedis() {
		try {
			if (projConstant.getRedisOpen() != 1) {//未开启
				return null;
			}
			if (jedisPool != null) {
				Jedis resource = jedisPool.getResource();
				return resource;
			} else {
				return null;
			}
		} catch (Exception ex) {
			logger.error("获取Redis客户端实例错误: error={}", ex.getMessage(), ex);
			return null;
		}
	}

	/**
	 * 设置String型值
	 *
	 * @param key
	 * @param value
	 * @return String
	 */
	public String putString(String key, String value) {
		String result = null;
		Jedis client = getJedis();
		if (client == null) {
			return result;
		}
		try {
			result = client.set(key, value);
		} catch (Exception e) {
			return null;
		} finally {
			if (null != client) {
				client.close();
			}
		}
		return result;
	}


	/**
	 * 设置带有过期时间的String型值，单位:秒
	 *
	 * @param key
	 * @param seconds
	 * @param value
	 * @return String
	 */
	public String putString(String key, String value, int seconds) {
		String result = null;
		Jedis client = getJedis();
		if (client == null) {
			return result;
		}
		try {
			result = client.setex(key, seconds, value);
		} catch (Exception e) {
			return null;
		} finally {
			if (null != client) {
				client.close();
			}
		}
		return result;
	}

	/**
	 * 获取String型值
	 *
	 * @param key
	 * @return String
	 */
	public String getString(String key) {
		String result = null;
		Jedis client = getJedis();
		if (client == null) {
			return result;
		}
		try {
			result = client.get(key);
		} catch (Exception e) {
			return null;
		} finally {
			if (null != client) {
				client.close();
			}
		}
		return result;
	}

	/**
	 * 设置Map型值
	 *
	 * @param key
	 * @param map
	 * @return String
	 */
	public String putMap(String key, Map<String, String> map) {
		String result = null;
		Jedis client = getJedis();
		if (client == null) {
			return result;
		}
		try {
			result = client.hmset(key, map);
		} catch (Exception e) {
			return null;
		} finally {
			if (null != client) {
				client.close();
			}
		}
		return result;
	}

	/**
	 * 设置Map型值
	 *
	 * @param key
	 * @param map
	 * @param seconds 过期时间(秒)
	 * @return String
	 */
	public String putMap(String key, Map<String, String> map, int seconds) {
		String result = null;
		Jedis client = getJedis();
		if (client == null) {
			return result;
		}
		try {
			result = client.hmset(key, map);
			client.expire(key, seconds);
		} catch (Exception e) {
			return null;
		} finally {
			if (null != client) {
				client.close();
			}
		}
		return result;
	}

	/**
	 * 获取Map型值
	 *
	 * @param key
	 * @return Map<String, String>
	 */
	public Map<String, String> getMap(String key) {
		Map<String, String> result = null;
		Jedis client = getJedis();
		if (client == null) {
			return result;
		}
		try {
			result = client.hgetAll(key);
		} catch (Exception e) {
			return null;
		} finally {
			if (null != client) {
				client.close();
			}
		}
		return result;
	}
}
