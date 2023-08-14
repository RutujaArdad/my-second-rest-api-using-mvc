package com.prowings.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.prowings")
public class SpringBeansConfig {
	
	
	
	public DriverManagerDataSource dataSource()
	{
	
	DriverManagerDataSource ds= new DriverManagerDataSource();
	ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
	ds.setUrl("jdbc:mysql://localhost:3306/spring-second-mvc-rest");
	ds.setUsername("root");
	ds.setPassword("Rutu@1909");
	return ds;
	

}
	@Bean
	public LocalSessionFactoryBean SessionFactory()
	
	{
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.prowings.entity");
		sessionFactory.setHibernateProperties(readHibernateprops());
		return sessionFactory;
	}

	private Properties readHibernateprops() {
		
		Properties props=new Properties();
		
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");

		return props;		
	}
	
	
	
}