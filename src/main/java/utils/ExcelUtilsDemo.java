package utils;

public class ExcelUtilsDemo {
    public static void main(String[] args) {

        String projectLocation = System.getProperty("user.dir");
        ExcelUtils excel = new ExcelUtils(projectLocation + "/excel/data.xlsx", "Лист1");

        excel.getRowCount();
        excel.getCellDataNumber(1,1);
        excel.getCellDataString(0,0);

    }
}
