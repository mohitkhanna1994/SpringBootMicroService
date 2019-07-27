package com.practice.practiceMysql.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
@PropertySource(value = "classpath:/${spring.profiles.active}/app.properties")
@EnableTransactionManagement
@ComponentScan("com.practice")
public class MySqlCofig {

	@Value("${database.driver.name}")
	public String driver;

	@Value("${database.url}")
	public String url;

	@Value("${database.username}")
	public String user;

	@Value("${database.password}")
	public String password;

	@Bean(name ="dataSource")
	public DataSource getDataSource() {
		DataSource dataSource = DataSourceBuilder.create().username(user).password(password).url(url)
				.driverClassName(driver).build();
		return dataSource;
	}
	
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.scanPackages("com.practice");
		return sessionBuilder.buildSessionFactory();
	}
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	@Bean
	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
		final DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		return dataSourceInitializer;
	}
}
