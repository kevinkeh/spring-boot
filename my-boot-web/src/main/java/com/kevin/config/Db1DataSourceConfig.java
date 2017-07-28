package com.kevin.config;

import com.kevin.property.DbConfigProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


/**
 * @author geyh
 * @create 2017-07-26 20:50
 */
@Configuration
//@EnableTransactionManagement
@MapperScan(basePackages = "com.kevin.dao.db1", sqlSessionFactoryRef = "carBasicSqlSessionFactory")
public class Db1DataSourceConfig extends BaseDataSourceConfig {


    public Db1DataSourceConfig(MybatisConfigSupport mybatisConfigSupport, DbConfigProperties dbConfigProperties) {
        super(mybatisConfigSupport);
        this.dbInfo = dbConfigProperties.getDb1();
    }

    @Bean("db1")
    @Primary
    @Override
    public DataSource createDataSource() throws Exception {
        return super.createDataSource();
    }

    /**
     * 事务管理器
     *
     * @param dataSource
     * @return
     */
//    @Bean("carBasicTxManager")
//    @Primary
//    @Override
//    public PlatformTransactionManager createTxManager(@Qualifier("carBasicDataSource") DataSource dataSource) {
//        return super.createTxManager(dataSource);
//    }

    @Bean("db1SqlSessionFactory")
    @Primary
    @Override
    public SqlSessionFactory createSqlSessionFactory(@Qualifier("db1") DataSource dataSource) throws Exception {
        return super.createSqlSessionFactory(dataSource);
    }

}
