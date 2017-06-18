package com.dp;

import redis.embedded.RedisServer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//import org.springframework.data.redis.connection.RedisServer;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.context.annotation.Bean;
import javax.annotation.PreDestroy;
import java.io.IOException;

@EnableRedisHttpSession  
public class HttpSessionConfig {
    private static RedisServer redisServer;

    @Bean
    public JedisConnectionFactory connectionFactory() throws IOException {
        redisServer = new RedisServer(6379);
        redisServer.start();
        return new JedisConnectionFactory();
    }

    @PreDestroy
    public void destroy() {
        redisServer.stop();
    }

}
