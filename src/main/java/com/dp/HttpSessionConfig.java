package com.dp;


import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//import org.springframework.data.redis.connection.RedisServer;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory; 
import org.springframework.context.annotation.Bean;


import java.io.IOException;

@EnableRedisHttpSession 
public class HttpSessionConfig {
        
}
