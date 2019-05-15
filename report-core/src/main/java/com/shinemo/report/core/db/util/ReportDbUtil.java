package com.shinemo.report.core.db.util;

import com.shinemo.myconf.client.jdbc.druid.DruidDataSource;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ReportDbUtil {

    private static final Map<String, DruidDataSource> dataSourceMap = new ConcurrentHashMap<>(100);

    /**
     * 根据名称获取数据源
     * @param dbName
     * @return
     */
    public static DataSource getDataSource(String dbName){
        DruidDataSource dataSource = dataSourceMap.get(dbName);
        if(dataSource == null){
            dataSource = new DruidDataSource();
            dataSource.setDbName(dbName);
            try {
                dataSource.init();
                dataSourceMap.put(dbName,dataSource);
            } catch (SQLException e) {
                log.error("[dataSource] init error dbName:"+dbName,e);
            }
        }
        return dataSource;
    }
}
