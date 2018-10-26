package com.orchard.platform.config;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 *@Author orchard.chang
 *@Date 2018/10/270:01
 *@Version 1.0
 **/
@MapperScan("com.orchard.platform.dao.mapper")

public class MybatisConfig {
    //@Bean
    //public DataSource dataSource() {
    //    return DruidDataSourceBuilder.create().build();
    //}

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("com.orchard.platform.dao.mapper/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    //@Bean
    //public Interceptor pageHelper() {
    //    PageIntercepts pageHelper = new PageIntercepts(dialect);
    //    return pageHelper;
    //}

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
