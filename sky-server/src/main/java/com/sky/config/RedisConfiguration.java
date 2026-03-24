package com.sky.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
@Slf4j
public class RedisConfiguration {

    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        log.info("开始创建RedisTemplate对象...");
        // 创建RedisTemplate对象
        RedisTemplate redisTemplate = new RedisTemplate();
        // 设置连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 创建JSON序列化工具
        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        // 设置Key的序列化器
        redisTemplate.setKeySerializer(RedisSerializer.string());

        return redisTemplate;
    }


}
