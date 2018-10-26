package com.orchard.platform.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 *@Author orchard.chang
 *@Date 2018/10/270:01
 *@Version 1.0
 **/
@MapperScan("com.orchard.platform.dao.mapper")

public class MybatisConfig {
    @Bean
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("com.orchard.platform.dao.mapper/*Mapper.xml"));
        return bean.getObject();
    }
}
