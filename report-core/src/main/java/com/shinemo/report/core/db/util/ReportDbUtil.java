package com.shinemo.report.core.db.util;

import com.shinemo.client.exception.BizException;
import com.shinemo.client.spring.SpringContextHolder;
import com.shinemo.myconf.client.jdbc.druid.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        DruidDataSource druidDataSource = SpringContextHolder.getBeanAndGenerateIfNotExist(dbName+"druidDataSource",DruidDataSource.class,
                val->{
                    val.addPropertyValue("dbName", dbName);
                    val.setInitMethodName("init");
                });
        return druidDataSource;
    }


    public static void releaseJdbcResource(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            log.error("[releaseJdbcResource] error", ex);
            throw new BizException();
        }

    }

    public static boolean checkSql(String sqlText) {
        sqlText = sqlText.trim();
        sqlText = sqlText.toLowerCase();
        int idx = sqlText.indexOf(';');
        if (idx> 0 && idx != sqlText.length() - 1) {
            return false;
        }
        if(sqlText.length() < 16){
            return false;
        }
        if(!sqlText.startsWith("select")){
            return false;
        }
        return true;
    }
}
