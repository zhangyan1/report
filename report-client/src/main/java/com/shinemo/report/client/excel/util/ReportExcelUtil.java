package com.shinemo.report.client.excel.util;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.shinemo.report.client.meta.domain.MetaHeader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ReportExcelUtil{

    public static void writeExcel(List<MetaHeader>headers,List<Map<String,Object>> rows) throws Exception {
        OutputStream out = new FileOutputStream("d://tmp/2007.xlsx");
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


}
