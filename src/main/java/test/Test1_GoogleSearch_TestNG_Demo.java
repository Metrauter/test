package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void googleSearch() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        login();
        gcp(wait);
        recipient(wait);

    }

    private void recipient(WebDriverWait wait) throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dashboard_main_content']//div[1]//div[1]//div[3]//div[2]//div[1]//a[1]")));
        driver.findElement(By.xpath("//div[@id='dashboard_main_content']//div[1]//div[1]//div[3]//div[2]//div[1]//a[1]")).click();
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='SelectedLovCountry']")));
        Select drpCountry = new Select(driver.findElement(By.xpath("//select[@name='SelectedLovCountry']")));
        drpCountry.selectByVisibleText("Bahamas");
        Thread.sleep(3000);
        Select drpRecSub = new Select(driver.findElement(By.xpath("//select[contains(@name,'SelectedServiceProviderSubType')]")));
        drpRecSub.selectByVisibleText("Clinics / Doctors Offices");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]")).sendKeys("Samantha");
        Thread.sleep(3000);

    }

//    private void star(WebDriverWait wait) {
//        driver.getWindowHandle();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='root']/div[@class='jss2 page-app']/div[@class='jss2 jss31']/div[@class='jss2 jss32']/div[@class='jss2 jss591']/div[@class='jss2 pbgap pxgap']/div[@class='jss2']/div[@class='jss594 jss618']/div[@class='jss595 jss628']/div[@class='jss49 jss53 jss50 jss691']/div[@class='jss692']/div[@class='scrollbar-container jss2 scroll jss697 ps ps--active-y']/div/div[1]/div[1]/div[1]/div[2]")));
//        driver.findElement(By.xpath("//body/div[@id='root']/div[@class='jss2 page-app']/div[@class='jss2 jss31']/div[@class='jss2 jss32']/div[@class='jss2 jss591']/div[@class='jss2 pbgap pxgap']/div[@class='jss2']/div[@class='jss594 jss618']/div[@class='jss595 jss628']/div[@class='jss49 jss53 jss50 jss691']/div[@class='jss692']/div[@class='scrollbar-container jss2 scroll jss697 ps ps--active-y']/div/div[1]/div[1]/div[1]/div[2]")).click();
//    }

    private void gcp(WebDriverWait wait) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-12']//div[2]//div[1]//div[3]")));
        driver.findElement(By.xpath("//div[@class='col-12']//div[2]//div[1]//div[3]")).click();
        Thread.sleep(3000);
    }

    private void login() throws InterruptedException {
        driver.get("https://polarisgcp-qa.polarisclients.com/Polaris-GCP-6.0.0-QA-Upgrade");
        driver.findElement(By.xpath("//*[@name='UserName']")).sendKeys("gcpadmin");
        driver.findElement(By.xpath("//*[@name='Password']")).sendKeys("@Polaris1");
        driver.findElement(By.cssSelector(".btn-primary")).click();
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDownTest() {

        driver.close();
        driver.quit();
        System.out.println("Test completed");

    }
}