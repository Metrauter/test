package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_GoogleSearch {

    public static void main(String[] args) {

        googleSearch();

    }

    public static void googleSearch() {

        String projectLocation = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("Automation");
        //driver.findElement(By.name("btnI")).click();
        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
        driver.close();
        System.out.println("Test completed");
    }
}
