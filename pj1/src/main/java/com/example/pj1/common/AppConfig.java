package com.example.pj1.common;


import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class AppConfig {

	@Bean
	public static PropertiesFactoryBean app() throws Exception {
		PropertiesFactoryBean pspc = new PropertiesFactoryBean();
		Resource resources = new PathMatchingResourcePatternResolver()
				.getResource("classpath:application.properties");
		pspc.setLocations(resources);
		return pspc;

	}
}
