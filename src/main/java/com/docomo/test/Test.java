package com.docomo.test;

import redis.clients.jedis.Jedis;

public class Test {
	
	public static void main(String[] args) {
		System.out.println("Test Jedis 2");
		
		Jedis jedis = new Jedis("localhost");
		jedis.set("foo", "bar");

		String value = jedis.get("foo");
		
		System.out.println("value:"+value);
		
		jedis.lpush("queue#tasks", "firstTask");
		jedis.lpush("queue#tasks", "secondTask");
		
		System.out.println(jedis.rpop("queue#tasks"));
		System.out.println(jedis.rpop("queue#tasks"));
	}

}

