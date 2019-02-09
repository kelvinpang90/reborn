package com.reborn.test;

import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args){
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.ping());
    }
}
