package ru.wonderkot.comicsChange.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import ru.wonderkot.comicsChange.dao.AuthorDao;

@Configuration
@ComponentScan(basePackages = "ru.wonderkot.comicsChange")
@MapperScan(basePackages = "ru.wonderkot.comicsChange.dao")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());

		sqlSessionFactory.setConfigLocation(new ClassPathResource(
				"mybatis-config.xml"));
		sqlSessionFactory
				.setTypeAliasesPackage("ru.wonderkot.comicsChange.model");
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	}

	@Bean
	public DataSource dataSource() throws NamingException {
		JndiObjectFactoryBean dataSource = new JndiObjectFactoryBean();
		dataSource.setJndiName("java:jboss/datasources/comicschange");
		try {
			dataSource.afterPropertiesSet();
		} catch (IllegalArgumentException e) {
			// rethrow
			throw new RuntimeException(e);
		}
		return (DataSource) dataSource.getObject();
	}

	/*
	 * @Bean public SqlSession sqlSession() throws Exception {
	 * SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(
	 * sqlSessionFactory()); return sessionTemplate; }
	 */

	@Bean
	MapperFactoryBean<AuthorDao> authorDao() throws Exception {
		MapperFactoryBean<AuthorDao> bean = new MapperFactoryBean<AuthorDao>();
		bean.setMapperInterface(AuthorDao.class);
		bean.setSqlSessionFactory(sqlSessionFactory());
		return bean;
	}

}
