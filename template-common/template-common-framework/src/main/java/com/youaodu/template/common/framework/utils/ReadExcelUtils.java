package com.youaodu.template.common.framework.utils;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadExcelUtils {

    public static  List<Map<String, String>> readFile() throws IOException, InvalidFormatException {
        String excelPath = "C:\\Users\\Administrator\\Desktop\\璐付产品报价2020-03-26(9)(1).xlsx";
        List<Map<String, String>> list = new ArrayList<>();
        File excel = new File(excelPath);
        if (excel.isFile() && excel.exists()) {   //判断文件是否存在
            String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
            Workbook wb;
            if ("xls".equals(split[1])) {
                FileInputStream fis = new FileInputStream(excel);   //文件流对象
                wb = new HSSFWorkbook(fis);
            } else if ("xlsx".equals(split[1])) {
                wb = new XSSFWorkbook(excel);
            } else {
                return null;
            }
            Sheet sheet = wb.getSheetAt(0);     //读取sheet 0
            int firstRowIndex = sheet.getFirstRowNum() + 1;   //第一行是列名，所以不读
            int lastRowIndex = sheet.getLastRowNum();
            for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                Row row = sheet.getRow(rIndex);
                Map<String,String> map = new HashMap<>();
                if (row != null) {
                    int firstCellIndex = row.getFirstCellNum();
                    int lastCellIndex = row.getLastCellNum();
                    int i = 0;
                    for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                        Cell cell = row.getCell(cIndex);
                        if (i == 0) {
                            map.put("name", cell.toString());
                        } else if (i == 1) {
                            map.put("productName", cell.toString());
                        } else if (i == 2) {
                            map.put("productCode", cell.toString().replaceAll("\\.","").replace("E7",""));
                        } else if (i == 3) {
                            map.put("faceValue", cell.toString());
                        } else if (i == 4) {
                            map.put("supplyDiscount", cell.toString());
                        } else if (i == 5) {
                            map.put("supplyPrice", cell.toString());
                        } else if (i == 6) {
                            map.put("saleDiscount", cell.toString());
                        } else if (i == 7) {
                            map.put("salePrice", cell.toString());
                        }
                        i++;
                    }
                    list.add(map);
                }
            }
            return list;
        }else {
            return null;
        }
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
        List<Map<String, String>> list = readFile();
        if (list!=null&list.size()>0){
            for (Map<String,String> map:list){
                System.out.println(map);
            }
        }

    }
}
