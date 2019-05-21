package com.shinemo.report.core.db.util;


import com.shinemo.report.client.db.domain.ReportParameter;
import org.apache.commons.lang3.StringUtils;
import javax.sql.DataSource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangyan
 */
public class MySqlQueryer extends AbstractQueryer implements SqlQueryService{

    public MySqlQueryer(DataSource dataSource, ReportParameter parameter) {
        super(dataSource, parameter);
    }

    @Override
    protected String preprocessSqlText(String sqlText){
        sqlText = StringUtils.stripEnd(sqlText.trim(), ";");
        sqlText = sqlText.split("where")[0];
        return sqlText + "limit 1";
    }
}
