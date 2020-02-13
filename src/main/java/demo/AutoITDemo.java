package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class AutoITDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        test();
    }

    public static void test() throws InterruptedException, IOException {
        String projectLocation = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.tinyupload.com/");
        driver.findElement(By.id("uploaded_file")).click();

        Runtime.getRuntime().exec(projectLocation + "/FileUploadSrcipt.exe");

        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
}