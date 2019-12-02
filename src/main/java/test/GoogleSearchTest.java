package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

public class GoogleSearchTest {

    private static WebDriver driver = null;

    public static void main(String[] args) {

        googleSearch();

    }

    public static void googleSearch() {

        String projectLocation = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.com");
        //driver.findElement(By.name("q")).sendKeys("Automation");

        GoogleSearchPage.textbox_search(driver).sendKeys("Automation");

        //driver.findElement(By.name("btnI")).click();
        //driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
        GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
        driver.close();
        System.out.println("Test completed");
    }
}
