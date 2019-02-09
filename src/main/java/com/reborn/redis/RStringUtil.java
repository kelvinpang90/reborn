package com.reborn.redis;

public interface RStringUtil {
    void set(String key,String value);
    void set(String key,String value,Integer seconds);
    String get(String key);
    void del(String key);
    void expire(String key,Integer seconds);
    Long incr(String key);
}
