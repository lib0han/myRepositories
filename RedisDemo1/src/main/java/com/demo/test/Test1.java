package com.demo.test;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class Test1 {
	Jedis jedis = null;

	@Before
	public void myBefore() {
		jedis = new Jedis("127.0.0.1", 6379);
	}

	// 新增
	@Test
	public void testInsert() {
		// 必须时public
		// 必须没有返回值
		// 必须没有参数
		String set = jedis.set("address", "千硕");
		System.out.println(set);
	}

	// 查询
	@Test
	public void get() {
		String address = jedis.get("address");
		System.out.println(address);
	}
	
	//修改
	@Test
	public void set() {
		String result = jedis.set("address", "北大青鸟");
		System.out.println(result);
	}
	//删除
	@Test
	public void del() {
		Long del = jedis.del("address");
		System.out.println(del);
	}
}
