package com.shinemo.report.client.common.domain;

import com.shinemo.client.common.ErrorInfo;

public interface ReportErrors {

    ErrorInfo PARAM_ERROR = new ErrorInfo(300001, "PARAM_ERROR", "参数错误");
    ErrorInfo SERVICE_ERROR = new ErrorInfo(300002, "SERVICE_ERROR", "服务错误");

    ErrorInfo DATASOURCE_ERROR = new ErrorInfo(300003, "DATASOURCE_ERROR", "数据源为空");
    ErrorInfo SQL_ERROR = new ErrorInfo(300004, "SQL_ERROR", "sql不合法");
    ErrorInfo TEMPLATE_NOT_EXIST = new ErrorInfo(300005, "TEMPLATE_NOT_EXIST", "模板不存在");
}
