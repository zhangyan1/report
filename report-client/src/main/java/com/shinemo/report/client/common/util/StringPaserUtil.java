package com.shinemo.report.client.common.util;

import com.shinemo.report.client.table.domain.TableQueryParamDO;
import org.apache.commons.lang.text.StrSubstitutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPaserUtil {

    /**
     * 通过字符分隔实现 去掉查询条件为空的查询条件
     * @param sql
     * @return
     */
    public static String sqlFormat(String sql){
        String sqlQuery = sql.split("where")[1];
        String originSql = sql.split("where")[0] + "where ";
        String[] queryArray = sqlQuery.split("and");
        for(int i=0;i<queryArray.length;i++){
            String iter = queryArray[i];
            if(iter.contains("$")){
                continue;
            }
            originSql = originSql+iter+"and";
        }
        return originSql.substring(0,originSql.length()-3);
    }

    /**
     *
     * @param sql 通过正则实现 去掉查询条件为空的查询条件
     * @return
     */
    public static String sqlFormatByRex(String sql){
        String regexOne = "where(\\s+\\w+?=\\$.*?})";
        String regexTwo = "(and\\s+\\w+?=\\$.*?})";
        Pattern pattern = Pattern.compile(regexOne);
        Matcher matcher = pattern.matcher(sql);
        sql = matcher.replaceAll("where 1=1");
        pattern = Pattern.compile(regexTwo);
        matcher = pattern.matcher(sql);
        sql = matcher.replaceAll("");
        return sql;
    }

    /**
     * 根据sql 和查询参数 获取组装后的sql
     * @param sql
     * @param params
     * @return
     */
    public static String getSqlByParams(String sql,List<TableQueryParamDO> params){
        if(params!=null&&params.size()>0){
            Map<String, String> replaceValue = new HashMap<>();
            for(TableQueryParamDO iter:params){
                replaceValue.put(iter.getKey(),iter.getValue());
            }
            StrSubstitutor strSubstitutor = new StrSubstitutor(replaceValue);
            sql = strSubstitutor.replace(sql);
        }
        return sqlFormatByRex(sql);
    }




    public static void main(String args[]){
        String a = "select * from buy_order_new where order_id=${orderId} and biz_type=3 and    biz_type=${} and order_type=${} ";
        System.out.println(sqlFormatByRex(a));

        String regex = "(and\\s+\\w+?=\\$.*?})|where(\\s+\\w+?=\\$.*?})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
        }
        System.out.println(matcher.replaceAll(" "));
    }
}
