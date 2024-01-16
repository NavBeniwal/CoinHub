package com.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderOptimized {
    public static String getKeyValue(String key) throws IOException {
        Properties pro = new Properties();
        FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\config.properties");
        pro.load(fis);
        String value = pro.getProperty(key);
        return value;
    }
    public static String getExcelSheetValue(int rowNumber, int cellNumber) throws IOException {
        String sheetPath="C:\\Users\\user.LAPTOP-0UHFE9FH\\OneDrive\\Documents\\WPS Cloud Files\\409986372\\ValidationMessageSheet.xlsx";
        File file = new File(sheetPath);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("ValidationMessage");
        return sheet.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
    }
}
