package com.kevin.config;

import com.kevin.property.DbConfigProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author geyh
 * @create 2017-07-28 16:17
 */
@EnableConfigurationProperties(DbConfigProperties.class)
public abstract class BaseDataSourceConfig {

    protected final MybatisConfigSupport mybatisConfigSupport;
    //由子类初始化
    protected DbConfigProperties.DbInfo dbInfo;

    public BaseDataSourceConfig(MybatisConfigSupport mybatisConfigSupport) {
        this.mybatisConfigSupport = mybatisConfigSupport;
    }

    protected DataSource createDataSource() throws Exception{
        return mybatisConfigSupport.createDataSource(dbInfo);
    }

    /**
     * 事务管理器
     * @param dataSource
     * @return
     */
    protected PlatformTransactionManager createTxManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    protected SqlSessionFactory createSqlSessionFactory(DataSource dataSource) throws Exception{
        return mybatisConfigSupport.createSqlSessionFactoryBean(dataSource, dbInfo).getObject();
    }

}
