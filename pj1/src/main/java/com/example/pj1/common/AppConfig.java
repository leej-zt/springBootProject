package com.example.pj1.common;


import javax.sql.DataSource;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class AppConfig {

	@Autowired
	private DataSource datasource;

	@Bean
	public ShiroFilterChainDefinition shiroFilterChaninDefinition() {
		DefaultShiroFilterChainDefinition chainDefinition =
				new DefaultShiroFilterChainDefinition();

		return chainDefinition;
	}

	@Bean
	public Realm realm() {
		JdbcRealm realm = new JdbcRealm();
		realm.setAuthenticationQuery(CommonDefine.USER_AUTH_QUERY);
		realm.setUserRolesQuery(CommonDefine.USER_ROLE_QUERY);
		realm.setDataSource(datasource);

		return realm;
	}

	@Bean
	public CacheManager cacheManager() {
		return new MemoryConstrainedCacheManager();
	}


	@Bean
	public static PropertiesFactoryBean app() throws Exception {
		PropertiesFactoryBean pspc = new PropertiesFactoryBean();
		Resource resources = new PathMatchingResourcePatternResolver()
				.getResource("classpath:application.properties");
		pspc.setLocations(resources);
		return pspc;

	}

}
