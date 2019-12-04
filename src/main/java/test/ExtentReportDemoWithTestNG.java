package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ExtentReportDemoWithTestNG {

    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;

    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeTest
    public void setUpTest() {
        String projectLocation = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws Exception {
        driver.get("https://google.com");
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
        test.pass("Navigated to google.com");
        test.log(Status.INFO, "Starting Test Case");
        test.info("This step shows of info (details)");
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.addScreenCaptureFromPath("screenshot.png");
    }

    @AfterTest
    public void tearDownTest() {
        driver.close();
        driver.quit();
        System.out.println("Test completed");
    }

    @AfterSuite
    public void treatDown() {
        extent.flush();
    }
}
