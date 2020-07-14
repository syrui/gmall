package com.gmall.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {

    public static HSSFWorkbook getInputStorageDtoHSSFWorkbook(String title, List<List<Object>> data) {
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("sheet1");
        sheet.setColumnWidth(2, 9000);
//        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, totalLength-2)); //
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 6000);
        sheet.setColumnWidth(3, 6000);
        sheet.setColumnWidth(4, 4000);
        sheet.setColumnWidth(5, 4000);

        //设置列宽
        for (int i = 6; i < 10; i++) {
            sheet.setColumnWidth(i, 4000);
        }

        int rowCount = 0;
        HSSFCellStyle baseRowStyle = ExcelUtil.getBaseRowStyle(wb);
        HSSFRow row;
        for (int i = 0; i < data.size(); i++) {
            row = sheet.createRow(rowCount++);
            for (int j = 0; j < data.get(i).size(); j++) {
                Object o = data.get(i).get(j);
                ExcelUtil.setCellValue(row, j, wb, o).setCellStyle(baseRowStyle);
            }
        }
        return wb;
    }

    /**
     * 导出Excel
     *
     * @param sheetName sheet名称
     * @param title     标题
     * @param values    内容
     * @param wb        HSSFWorkbook对象
     * @return
     */
    public static HSSFWorkbook getInputStorageDtoHSSFWorkbook(String sheetName, String[] title, String[][] values, HSSFWorkbook wb) {

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        //创建内容
        for (int i = 0; i < values.length; i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < values[i].length; j++) {
                //将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
        return wb;
    }

    /**
     * 导出Excel,自定义标题格式
     *
     * @param sheetName sheet名称
     * @param data    内容
     * @param wb        HSSFWorkbook对象
     * @return
     */
    public static HSSFWorkbook getInputStorageDtoHSSFWorkbookByCustomizeTitle(String sheetName, List<List<Object>> data, HSSFWorkbook wb, int startRow) {

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.getSheet(sheetName) == null ? wb.createSheet(sheetName) : wb.getSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(startRow);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;

        HSSFCellStyle baseRowStyle = ExcelUtil.getBaseRowStyle(wb);
        //创建内容
        for (int i = 0; i < data.size(); i++) {
            row = sheet.createRow(startRow++);
            for (int j = 0; j < data.get(i).size(); j++) {
                Object o = data.get(i).get(j);
                ExcelUtil.setCellValue(row, j, wb, o).setCellStyle(baseRowStyle);
            }
        }

//        for (int i = 0; i < values.length; i++) {
//            row = sheet.createRow(i + 1);
//            for (int j = 0; j < values[i].length; j++) {
//                //将内容按顺序赋给对应的列对象
//                row.createCell(j).setCellValue(values[i][j]);
//            }
//        }
        return wb;
    }


    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    /**
     * 判断Excel的版本,获取Workbook
     *
     * @param in
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbok(InputStream in, File file) throws IOException {
        Workbook wb = null;
        if (file.getName().endsWith(EXCEL_XLS)) {  //Excel 2003
            wb = new HSSFWorkbook(in);
        } else if (file.getName().endsWith(EXCEL_XLSX)) {  // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

    /**
     * 判断文件是否是excel
     *
     * @throws Exception
     */
    public static void checkExcelVaild(File file) throws Exception {
        if (!file.exists()) {
            throw new Exception("文件不存在");
        }
        if (!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))) {
            throw new Exception("文件不是Excel");
        }
    }


    /**
     * 粗体显示
     */
    public static HSSFCellStyle getFirstRowStyle(HSSFWorkbook wb) {
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFFont font = wb.createFont();
        font.setFontName("宋体");
        font.setBold(true);//粗体显示
        font.setFontHeightInPoints((short) 18);//设置字体大小
        style.setFont(font);
        return style;
    }

    /**
     * 基础的样式
     */
    public static HSSFCellStyle getBaseRowStyle(HSSFWorkbook wb) {
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    public static XSSFCell setCellValue(XSSFRow row, int count, XSSFWorkbook wb, Object o) {
        XSSFCell cellEntry = row.createCell(count);
        if (o instanceof String) {
            cellEntry.setCellValue((String) o);
        } else {
            try {
                cellEntry.setCellValue(Double.valueOf(o + ""));
            } catch (Exception e) {
                cellEntry.setCellValue(o + "");
            }
        }
//        cellEntry.setCellStyle(ExcelUtil.getBaseRowStyle(wb));
        return cellEntry;
    }

    public static HSSFCell setCellValue(HSSFRow row, int count, HSSFWorkbook wb, Object o) {
        HSSFCell cellEntry = row.createCell(count);
        if (o instanceof String) {
            cellEntry.setCellValue((String) o);
        } else {
            try {
                cellEntry.setCellValue(Double.valueOf(o + ""));
            } catch (Exception e) {
                cellEntry.setCellValue(o + "");
            }
        }
//        cellEntry.setCellStyle(ExcelUtil.getBaseRowStyle(wb));
        return cellEntry;
    }


    public static Object getValue(Cell cell) {
        Object obj = null;
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                obj = cell.getBooleanCellValue();
                break;
            case ERROR:
                obj = cell.getErrorCellValue();
                break;
            case NUMERIC:
                obj = cell.getNumericCellValue();
                break;
            case STRING:
                obj = cell.getStringCellValue();
                break;
            default:
                break;
        }
        return obj;
    }



    public static  List<Object> buildData(Object o, List<String> fieldName){
        List<Object> data = new ArrayList<>();
        for (String field : fieldName) {
            // 将属性的首字母大写
            String methodName = field.replaceFirst(field.substring(0, 1), field.substring(0, 1).toUpperCase());
            try {
                Method methodGet = o.getClass().getMethod("get" + methodName);
                // 调用getter方法获取属性值
                Object value = methodGet.invoke(o);
                if("shedType".equals(field)){
                    if(value==null){
                        data.add("未知");
                    } else if (value.equals(0) ) {
                        data.add("育雏舍");
                    } else if (value.equals(1)) {
                        data.add("育成舍");
                    } else if (value.equals(2)) {
                        data.add("产蛋舍");
                    }

                }else if("flockStatus".equals(field)){
                    if(value==null){
                        data.add("未知");
                    } else if (value.equals(0)){
                         data.add("育雏期");
                    }else if(value.equals(1)){
                         data.add("育成期");
                    }else if(value.equals(2)){
                         data.add("育成期");
                    }else if(value.equals(3)){
                         data.add("已淘汰");
                    }
                }else if("hatchStatus".equals(field)){
                    if(value==null){
                        data.add("未知");
                    } else if(value.equals(0)){
                        data.add("已入孵");
                    }else if(value.equals(1)){
                        data.add("已照蛋");
                    }else if(value.equals(2)){
                        data.add("已转雏");
                    }else if(value.equals(3)){
                        data.add("已发苗");
                    }

                } else {

                    data.add(value==null?"":value);
                }
            } catch (Exception e) {

                data.add("");
            }
        }

        return data;
    }

    /**
     * 在原来的基础上增加构建每行数据
     * @param data
     * @param o
     * @param fieldName
     * @return
     */
    public static  List<Object> addData(List<Object> data,Object o, List<String> fieldName){
        for (String field : fieldName) {
            // 将属性的首字母大写
            String methodName = field.replaceFirst(field.substring(0, 1), field.substring(0, 1).toUpperCase());
            try {
                Method methodGet = o.getClass().getMethod("get" + methodName);
                // 调用getter方法获取属性值
                Object value = methodGet.invoke(o);
                if("shedType".equals(field)){
                    if(value==null){
                        data.add("未知");
                    } else if (value.equals(0) ) {
                        data.add("育雏舍");
                    } else if (value.equals(1)) {
                        data.add("育成舍");
                    } else if (value.equals(2)) {
                        data.add("产蛋舍");
                    }

                }else if("flockStatus".equals(field)){
                    if(value==null){
                        data.add("未知");
                    } else if (value.equals(0)){
                        data.add("育雏期");
                    }else if(value.equals(1)){
                        data.add("育成期");
                    }else if(value.equals(2)){
                        data.add("育成期");
                    }else if(value.equals(3)){
                        data.add("已淘汰");
                    }
                }else if("hatchStatus".equals(field)){
                    if(value==null){
                        data.add("未知");
                    } else if(value.equals(0)){
                        data.add("已入孵");
                    }else if(value.equals(1)){
                        data.add("已照蛋");
                    }else if(value.equals(2)){
                        data.add("已转雏");
                    }else if(value.equals(3)){
                        data.add("已发苗");
                    }

                } else {

                    data.add(value==null?"":value);
                }
            } catch (Exception e) {

                data.add("");
            }
        }

        return data;
    }
}