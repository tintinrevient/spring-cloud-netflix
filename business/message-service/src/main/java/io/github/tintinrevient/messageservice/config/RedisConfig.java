package io.github.tintinrevient.messageservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

	@Value("${spring.redis.host}")
	private String REDIS_HOST;
	@Value("${spring.redis.port}")
	private int REDIS_PORT;
	@Value("${spring.redis.password}")
	private String REDIS_PASSWORD;

	@Bean
	protected JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName(REDIS_HOST);
		factory.setPort(REDIS_PORT);
		factory.setPassword(REDIS_PASSWORD);

		return factory;
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}
}