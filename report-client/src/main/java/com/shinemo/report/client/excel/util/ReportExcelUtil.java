package com.shinemo.report.client.excel.util;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.shinemo.client.util.GsonUtil;
import com.shinemo.report.client.meta.domain.MetaHeader;
import com.shinemo.report.client.table.domain.SheetInfoDO;
import com.shinemo.report.client.table.domain.TableInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

@Slf4j
public class ReportExcelUtil{


    public static void writeExcel(TableInfoDO tableInfoDO,HttpServletResponse response){
        try {
            ServletOutputStream servletOutputStream = response.getOutputStream();
            ExcelWriter writer = EasyExcelFactory.getWriterWithTempAndHandler(null,servletOutputStream, ExcelTypeEnum.XLSX,true,
                    new WriteHandlerImpl());
            for(int i=0;i<tableInfoDO.getSheetInfos().size();i++){
                SheetInfoDO sheetInfoDO = tableInfoDO.getSheetInfos().get(i);
                int sheetNo = i+1;
                Sheet sheet = new Sheet(sheetNo);
                sheet.setSheetName(StringUtils.isBlank(sheetInfoDO.getSheetName())?"sheet"+sheetNo:sheetInfoDO.getSheetName());
                sheet.setHead(createListStringHead(sheetInfoDO.getHeaders()));//设置表头
                sheet.setAutoWidth(Boolean.TRUE);//设置自适应宽度
                writer.write1(createListObject(sheetInfoDO.getRows(),sheetInfoDO.getHeaders()), sheet);
            }
            writer.finish();
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename="+tableInfoDO.getFileName()+".xlsx");
            servletOutputStream.flush();
        } catch (IOException e) {
            log.error("[wireteExcel] error param:"+ GsonUtil.toJson(tableInfoDO),e);
        }

    }

    public static void writeExcel(List<MetaHeader>headers,List<Map<String,Object>> rows) throws Exception {
        OutputStream out = new FileOutputStream("d://tmp/tmp.xlsx");
        ExcelWriter writer = EasyExcelFactory.getWriterWithTempAndHandler(null,out, ExcelTypeEnum.XLSX,true,
                new WriteHandlerImpl());
        Sheet sheet1 = new Sheet(1, 3);
        sheet1.setSheetName("sheet1");
        sheet1.setHead(createListStringHead(headers));//设置表头
        sheet1.setAutoWidth(Boolean.TRUE);//设置自适应宽度
        writer.write1(createListObject(rows,headers), sheet1);
        writer.finish();
        out.close();
    }

    private static List<List<Object>> createListObject(List<Map<String, Object>> rows, List<MetaHeader> headers) {
        List<List<Object>> result = new ArrayList<>();
        for(Map<String, Object> map: rows){
            List<Object> objects = new ArrayList<>();
            for(MetaHeader iter:headers){
                objects.add(map.get(iter.getKey()));
            }
            result.add(objects);
        }
        return result;
    }


    private static List<List<String>> createListStringHead(List<MetaHeader> headers){
        List<List<String>> result = new ArrayList<>();
        headers.sort(Comparator.comparingInt(val->val.getIndex()));
        for(MetaHeader header:headers){
            List<String> list = new ArrayList<>();
            list.add(header.getValue());
            result.add(list);
        }
        return result;
    }

    public static void main(String args[]){
        List<MetaHeader>headers = new ArrayList<>();
        MetaHeader a = new MetaHeader();
        a.setIndex(0);
        a.setKey("a");
        a.setValue("第一列");
        MetaHeader b = new MetaHeader();
        b.setIndex(1);
        b.setKey("b");
        b.setValue("第二列");
        headers.add(a);
        headers.add(b);
        List<Map<String,Object>> lists = new ArrayList<>();
        Map<String,Object> mapA = new HashMap<>();
        mapA.put("a","张三");
        mapA.put("b","吃饭");
        Map<String,Object> mapB = new HashMap<>();
        mapB.put("a","李四");
        mapB.put("b","睡觉");
        lists.add(mapA);
        lists.add(mapB);
        try {
            writeExcel(headers,lists);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
