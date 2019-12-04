package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1_GoogleSearch_TestNG_Demo {

    WebDriver driver = null;

    @BeforeTest
    public void setUpTest() {

        String projectLocation = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void googleSearch() {

        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("Automation");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

    }

    @AfterTest
    public void tearDownTest() {

        driver.close();
        driver.quit();
        System.out.println("Test completed");

    }
}