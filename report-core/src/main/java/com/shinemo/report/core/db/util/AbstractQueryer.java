package com.shinemo.report.core.db.util;


import com.shinemo.client.exception.BizException;
import com.shinemo.report.client.db.domain.ReportMetaDataColumn;
import com.shinemo.report.client.db.domain.ReportParameter;
import com.shinemo.report.client.db.domain.ReportQueryParamItem;
import com.shinemo.report.client.meta.domain.MetaHeader;
import lombok.extern.slf4j.Slf4j;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;


/**
 * zhangyan
 */
@Slf4j
public abstract class AbstractQueryer {

    protected final DataSource dataSource;
    protected final ReportParameter parameter;
    protected final List<MetaHeader> metaHeaders;

    protected AbstractQueryer(final DataSource dataSource, final ReportParameter parameter) {
        this.dataSource = dataSource;
        this.parameter = parameter;
        this.metaHeaders = this.parameter == null ?
            new ArrayList<>(0) :
            new ArrayList<>(this.parameter.getMetaHeaders());
    }

    /**
     * 获取元数据列
     * @param sqlText
     * @return
     */
    public List<ReportMetaDataColumn> parseMetaDataColumns(final String sqlText) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<ReportMetaDataColumn> columns = null;
        try {
            log.debug("[parseMetaDataColumns] Parse Report MetaDataColumns SQL:{},", sqlText);
            conn = this.getJdbcConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(this.preprocessSqlText(sqlText));
            final ResultSetMetaData rsMataData = rs.getMetaData();
            final int count = rsMataData.getColumnCount();
            columns = new ArrayList<>(count);
            for (int i = 1; i <= count; i++) {
                final ReportMetaDataColumn column = new ReportMetaDataColumn();
                column.setKey(rsMataData.getColumnLabel(i));
                column.setDataType(rsMataData.getColumnTypeName(i));
                column.setWidth(rsMataData.getColumnDisplaySize(i));
                columns.add(column);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            ReportDbUtil.releaseJdbcResource(conn, stmt, rs);
        }
        return columns;
    }

    /**
     * 获取下拉框数据 当查询类型为sql动态获取时 使用
     * @param sqlText
     * @return
     */
    public List<ReportQueryParamItem> parseQueryParamItems(final String sqlText) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        final HashSet<String> set = new HashSet<>();
        final List<ReportQueryParamItem> rows = new ArrayList<>();
        try {
            log.debug(sqlText);
            conn = this.getJdbcConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlText);
            while (rs.next()) {
                String name = rs.getString("name");
                String text = rs.getString("text");
                name = (name == null) ? "" : name.trim();
                text = (text == null) ? "" : text.trim();
                if (!set.contains(name)) {
                    set.add(name);
                }
                rows.add(new ReportQueryParamItem(name, text));
            }
        } catch (final SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            ReportDbUtil.releaseJdbcResource(conn, stmt, rs);
        }
        set.clear();
        return rows;
    }

    public List<MetaHeader> getMetaHeaders() {
        return this.metaHeaders;
    }

    /**
     * 获取数据集
     * @return
     */
    public List<Map<String,Object>> getMetaDataRows() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            log.debug(this.parameter.getSqlText());
            conn = this.getJdbcConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(this.preprocessSqlText(this.parameter.getSqlText()));
            return this.getMetaDataRows(rs, this.parameter.getMetaHeaders());
        } catch (final Exception ex) {
            log.error(String.format("SqlText:%s，Msg:%s", this.parameter.getSqlText(), ex));
            throw new BizException();
        } finally {
            ReportDbUtil.releaseJdbcResource(conn, stmt, rs);
        }
    }

    /**
     * 获取查询结果集 (后续可以把map接转为object)
     * @param rs
     * @param metaHeaders
     * @return
     * @throws SQLException
     */
    protected List<Map<String,Object>> getMetaDataRows(final ResultSet rs, final List<MetaHeader> metaHeaders)
        throws SQLException {
        final List<Map<String,Object>> rows = new ArrayList<>();
        while (rs.next()) {
            final Map<String,Object> row = new HashMap<>();
            for (final MetaHeader metaHeader : metaHeaders) {
                Object value = rs.getObject(metaHeader.getMainKey());
                if (metaHeader.getOriginDataType().contains("BINARY")) {
                    value = new String((byte[])value);
                }
                //JSON 字段类型  以及计算型 以及拼凑型
                row.put(metaHeader.getKey(),value);
            }
            rows.add(row);
        }
        return rows;
    }
    /**
     * 预处理获取报表列集合的sql语句，
     * 在这里可以拦截全表查询等sql， 因为如果表的数据量很大，将会产生过多的内存消耗，甚至性能问题
     *
     * @param sqlText 原sql语句
     * @return 预处理后的sql语句
     */
    protected String preprocessSqlText(String sqlText) {
        return sqlText;
    }

    /**
     * 获取当前报表查询器的JDBC Connection对象
     * @return Connection
     */
    protected Connection getJdbcConnection() {
        try {
            return this.dataSource.getConnection();
        } catch (final Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
