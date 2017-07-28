package com.kevin.config;

import com.kevin.property.DbConfigProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author geyh
 * @create 2017-07-27 12:22
 */
@Configuration
//@EnableTransactionManagement
@MapperScan(basePackages = "com.kevin.dao.db2", sqlSessionFactoryRef = "carOsdSqlSessionFactory")
public class Db2DataSourceConfig extends BaseDataSourceConfig {

    public Db2DataSourceConfig(MybatisConfigSupport mybatisConfigSupport, DbConfigProperties dbConfigProperties) {
        super(mybatisConfigSupport);
        this.dbInfo = dbConfigProperties.getDb2();
    }

    @Bean("db2")
    @Override
    public DataSource createDataSource() throws Exception {
        return super.createDataSource();
    }

    /**
     * 事务管理器
     * @param dataSource
     * @return
     */
//    @Bean("carOsdTxManager")
//    @Override
//    public PlatformTransactionManager createTxManager(@Qualifier("carOSDDataSource") DataSource dataSource) {
//        return super.createTxManager(dataSource);
//    }

    /**
     * 事务管理器
     *
     * @param dataSource
     * @return
     */
    @Bean("db2SqlSessionFactory")
    @Override
    public SqlSessionFactory createSqlSessionFactory(@Qualifier("db2") DataSource dataSource) throws Exception {
        return super.createSqlSessionFactory(dataSource);
    }
}

