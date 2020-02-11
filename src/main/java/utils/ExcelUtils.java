package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    static XSSFWorkbook workbook = null;
    static XSSFSheet sheet;

    public ExcelUtils(String excelPath, String sheetName) {
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //getRowCount();
        getCellDataString(0, 0);
        getCellDataNumber(1, 1);
    }

    public static int getRowCount() {
        int rowCount = 0;
        rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("No of rows : " + rowCount);
        return rowCount;
    }

    public static int getColCount() {
        int colCount = 0;
        colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("No of columns : " + colCount);
        return colCount;
    }

    public static String getCellDataString(int rowNum, int colNum) {
        String cellData = null;
        cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        return cellData;
    }

    public static void getCellDataNumber(int rowNum, int colNum) {
        double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
    }
}