package com.kevin.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author geyh
 * @create 2017-07-28 14:56
 */
@ConfigurationProperties(prefix = "dbconfig")
@Component
public class DbConfigProperties {

    private DbInfo db1;

    private DbInfo db2;

    public DbInfo getDb1() {
        return db1;
    }

    public void setDb1(DbInfo db1) {
        this.db1 = db1;
    }

    public DbInfo getDb2() {
        return db2;
    }

    public void setDb2(DbInfo db2) {
        this.db2 = db2;
    }

    public static class DbInfo {
        //数据库名
        private String dbName;
        //别名包路径
        private String typeAliasesPackage;
        //sqlmap路径
        private String mapperLocations;

        public String getDbName() {
            return dbName;
        }

        public void setDbName(String dbName) {
            this.dbName = dbName;
        }

        public String getTypeAliasesPackage() {
            return typeAliasesPackage;
        }

        public void setTypeAliasesPackage(String typeAliasesPackage) {
            this.typeAliasesPackage = typeAliasesPackage;
        }

        public String getMapperLocations() {
            return mapperLocations;
        }

        public void setMapperLocations(String mapperLocations) {
            this.mapperLocations = mapperLocations;
        }
    }


}
