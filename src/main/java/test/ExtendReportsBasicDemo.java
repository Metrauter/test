package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtendReportsBasicDemo {

    private static WebDriver driver = null;

    public static void main(String[] args) {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        ExtentTest test = extent.createTest("Google Search Test One", "this is a test to validate Google search");

        String projectLocation = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        test.log(Status.INFO, "Starting Test Case");
        driver.get("https://google.com");
        test.pass("Navigated to google.com");

        driver.findElement(By.name("q")).sendKeys("Automation");
        test.pass("Entered text in SearchBox");

        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        test.pass("Pressed Enter");

        driver.close();
        driver.quit();
        test.pass("Closed the browser");

        test.info("Test Completed");

        extent.flush();
    }
}
