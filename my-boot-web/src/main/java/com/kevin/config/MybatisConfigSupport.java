package com.kevin.config;

import com.kevin.property.DbConfigProperties;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.BeanUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author geyh
 * @create 2017-07-27 10:57
 */
@Component
public class MybatisConfigSupport {

    //yml配置datasource使用
//    private final DataSourceProperties dataSourceProperties;
    private final MybatisProperties mybatisProperties;
    //加载classpath文件使用
//    private final ResourceLoader resourceLoader;

    public MybatisConfigSupport(MybatisProperties mybatisProperties) {
//        this.dataSourceProperties = dataSourceProperties;
        this.mybatisProperties = mybatisProperties;
//        this.resourceLoader = resourceLoader;
    }

    public DataSource createDataSource(DbConfigProperties.DbInfo dbInfo) throws Exception {
//        DalDataSourceFactory dalDataSourceFactory = new DalDataSourceFactory();
//        return dalDataSourceFactory.createDataSource(dbInfo.getDbName());
        return null;
    }

    public SqlSessionFactoryBean createSqlSessionFactoryBean(DataSource dataSource, DbConfigProperties.DbInfo dbInfo) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(dbInfo.getTypeAliasesPackage());
        sqlSessionFactoryBean.setMapperLocations(this.resolveMapperLocations(dbInfo.getMapperLocations()));
        Configuration configuration = new Configuration();
        if (mybatisProperties.getConfiguration() != null) {
            BeanUtils.copyProperties(mybatisProperties.getConfiguration(), configuration);
        }
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean;
    }

    /**
     * 解析classpath xml
     * @param mapperLocation
     * @return
     */
    private Resource[] resolveMapperLocations(String mapperLocation) {
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        List<Resource> resources = new ArrayList<>();
        if (StringUtils.isNotBlank(mapperLocation)) {
            try {
                Resource[] mappers = resourceResolver.getResources(mapperLocation);
                resources.addAll(Arrays.asList(mappers));
            } catch (IOException e) {// ignore}
            }
        }
        return resources.toArray(new Resource[resources.size()]);
    }

}
