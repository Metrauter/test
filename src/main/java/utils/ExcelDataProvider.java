package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

    WebDriver driver = null;

    @BeforeTest
    public void setUpTest() {
        String projectLocation = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "test1data")
    public void test1(String username, String password) throws InterruptedException {
        System.out.println(username + " | " + password);

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername"));
        driver.findElement(By.id("txtPassword"));
        Thread.sleep(2000);
    }

    @DataProvider(name = "test1data")
    public Object[][] getData() {
        String projectLocation = System.getProperty("user.dir");
        String excelPath = projectLocation + "/excel/data.xlsx";
        Object data[][] = testData(excelPath, "Лист1");
        return data;
    }

    public Object[][] testData(String excelPath, String SheetName) {

        ExcelUtils excel = new ExcelUtils(excelPath, SheetName);

        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();

        Object data[][] = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                String cellData = excel.getCellDataString(i, j);
//                System.out.print(cellData + " | ");
                data[i - 1][j] = cellData;
            }
//            System.out.println();
        }
        return data;
    }
}