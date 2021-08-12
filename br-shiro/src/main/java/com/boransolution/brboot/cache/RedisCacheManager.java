package com.boransolution.brboot.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/***
 * Redis缓存管理器
 *
 * @author : xy
 *
 * @date : 2021/8/11
 **/
public class RedisCacheManager implements CacheManager {
    /**
     *
     * @param catchName *认证或者授权缓存的统一名称
     * @param <K>
     * @param <V>
     * @return
     * @throws CacheException
     */
    @Override
    public <K, V> Cache<K, V> getCache(String catchName) throws CacheException {
        return new RedisCache<K, V>(catchName);
    }
}
