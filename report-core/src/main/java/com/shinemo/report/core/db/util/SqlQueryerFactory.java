package com.shinemo.report.core.db.util;



import com.shinemo.report.client.db.domain.ReportParameter;

import javax.sql.DataSource;
import java.lang.reflect.Constructor;

/**
 * 工厂
 * zhangyan
 */
public class SqlQueryerFactory {

    public static SqlQueryService create(final DataSource dataSource) {
        return create(dataSource, null);
    }

    public static SqlQueryService create(final DataSource dataSource, final ReportParameter parameter) {
        if (dataSource != null) {
            try {
                //TODO 后续这里改为根据类型 生成不同的Queryer
                final Constructor<?> constructor = MySqlQueryer.class.getConstructor(DataSource.class, ReportParameter.class);
                return (SqlQueryService)constructor.newInstance(dataSource, parameter);
            } catch (final Exception ex) {
                throw new RuntimeException("create report engine queryer error", ex);
            }
        }
        return null;
    }
}
