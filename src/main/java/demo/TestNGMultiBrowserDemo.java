package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {

    WebDriver driver = null;
    String projectLocation = System.getProperty("user.dir");

    @BeforeTest
    @Parameters("browserName")
    public void setup(String browserName) {
        System.out.println("Browser name is : " + browserName);
        System.out.println("Thread id : "+Thread.currentThread().getId());

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckodriver/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", projectLocation + "/lib/iedriver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://google.com");
        Thread.sleep(4000);
    }

    @AfterTest
    public void teardown() {
        driver.close();
        System.out.println("Test completed successfully");
    }
}
