package demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitDemo {

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    public static void test() throws InterruptedException {
        String projectLocation = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com/");
        driver.findElement(By.name("q")).sendKeys("Abcd");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

        //driver.findElement(By.linkText("ABCD - NIMH Data Archive - NIH")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement linkElement = driver.findElement(By.linkText("ABCD - NIMH Data Archive - NIH"));

                if (linkElement.isEnabled()) {
                    System.out.println("Element found");
                }
                return linkElement;
            }
        });

        element.click();

        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
}