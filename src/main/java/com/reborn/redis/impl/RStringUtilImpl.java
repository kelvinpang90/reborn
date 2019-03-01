package com.reborn.redis.impl;

import com.reborn.redis.RStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;

@Transactional
@Repository("rStringUtil")
public class RStringUtilImpl implements RStringUtil {
    @Autowired
    private JedisPool jedisPool;
    @Override
    public void set(String key, String value) {
        jedisPool.getResource().set(key,value);
    }

    @Override
    public void set(String key, String value, Integer seconds) {
        jedisPool.getResource().setex(key,seconds,value);
    }

    @Override
    public String get(String key) {
        return jedisPool.getResource().get(key);
    }

    @Override
    public void del(String key) {
        jedisPool.getResource().del(key);
    }

    @Override
    public void expire(String key, Integer seconds) {
        jedisPool.getResource().expire(key,seconds);
    }

    @Override
    public Long incr(String key) {
        return jedisPool.getResource().incr(key);
    }

    @Override
    public String getset(String key, String value) {
        return jedisPool.getResource().getSet(key,value);
    }

    @Override
    public long setnx(String key, String value) {
        return jedisPool.getResource().setnx(key,value);
    }
}
