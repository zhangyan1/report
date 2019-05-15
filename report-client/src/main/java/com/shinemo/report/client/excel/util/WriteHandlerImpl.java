package com.shinemo.report.client.excel.util;

import com.alibaba.excel.event.WriteHandler;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


public class WriteHandlerImpl implements WriteHandler{

    @Override
    public void sheet(int sheetNo, Sheet sheet) {
        System.out.println("sheet:"+sheetNo);
    }

    @Override
    public void row(int rowNum, Row row) {
        System.out.println("row:"+rowNum);
    }

    @Override
    public void cell(int cellNum, Cell cell) {
        System.out.println("cell:"+cellNum);
    }
}
