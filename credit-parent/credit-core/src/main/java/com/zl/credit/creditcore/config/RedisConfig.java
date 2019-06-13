
package com.zl.credit.creditcore.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@Configuration
public class RedisConfig { // 注入集群节点信息

	@Value("${spring.redis.cluster.nodes}")
	private String clusterNodes;

	@Bean
	public JedisCluster getJedisCluster() { // 分割集群节点 
		String[] nodesStr = clusterNodes.split(",");
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		for (String nodeStr : nodesStr) {
			String[] hostAndport = nodeStr.split(":");
			nodes.add(new HostAndPort(hostAndport[0], Integer.parseInt(hostAndport[1])));
		}
		JedisCluster jedisCluster = new JedisCluster(nodes);
		return jedisCluster;
	}
}
