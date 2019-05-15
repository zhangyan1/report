package com.shinemo.report.core.db.util;


import com.shinemo.report.client.db.domain.ReportParameter;
import org.apache.commons.lang3.StringUtils;
import javax.sql.DataSource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangyan
 */
public class MySqlQueryer extends AbstractQueryer{

    public MySqlQueryer(DataSource dataSource, ReportParameter parameter) {
        super(dataSource, parameter);
    }

    @Override
    protected String preprocessSqlText(String sqlText) {
        sqlText = StringUtils.stripEnd(sqlText.trim(), ";");
        final Pattern pattern = Pattern.compile("limit.*?$", Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(sqlText);
        if (matcher.find()) {
            sqlText = matcher.replaceFirst("");
        }
        return sqlText + " limit 1";
    }
}
