package com.boransolution.brboot.cache;

import com.boransolution.brboot.util.ApplicationContextUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Collection;
import java.util.Set;

/***
 * 自定义Redis缓存的实现
 *
 * @author : xy
 *
 * @date : 2021/8/11
 **/
public class RedisCache<k, v> implements Cache<k, v> {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public v get(k k) throws CacheException {
        log.info("get key：", k);
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        return (v) redisTemplate.opsForValue().get(k.toString());
    }

    @Override
    public v put(k k, v v) throws CacheException {
        log.info("put key：", k);
        log.info("put value：", v);
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set(k.toString(), v);
        return null;
    }

    @Override
    public v remove(k k) throws CacheException {
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<k> keys() {
        return null;
    }

    @Override
    public Collection<v> values() {
        return null;
    }
}
