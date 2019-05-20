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
    protected String preprocessSqlText(String sqlText) {
        //TODO 格式化封装sql
        sqlText = StringUtils.stripEnd(sqlText.trim(), ";");
        final Pattern pattern = Pattern.compile("limit.*?$", Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(sqlText);
        if (matcher.find()) {
            sqlText = matcher.replaceFirst("");
        }
        sqlText = sqlText.split("where")[0];
        return sqlText + " where biz_type='18' limit 100";
    }
}
