package listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNGListenerDemo {

    @Test
    public void test1() {
        System.out.println("I'm inside test 1");
    }

    @Test
    public void test2() {
        System.out.println("I'm inside test 2");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("text");
        driver.findElement(By.name("abc")).sendKeys("text");
        driver.close();
    }

    @Test
    public void test3() {
        System.out.println("I'm inside test 3");
        throw new SkipException("This test is skipped");
    }
}