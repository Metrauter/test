import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

//        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.operadriver().setup();
//        WebDriverManager.phantomjs().setup();
//        WebDriverManager.edgedriver().setup();
//        WebDriverManager.iedriver().setup();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        //WebElement textBox = driver.findElement(By.name("q"));
        //textBox.sendKeys("text");

        List<WebElement> listOfElements = driver.findElements(By.xpath("//input"));
        int count = listOfElements.size();
        System.out.println("Count of Input elements : " + count);


        Thread.sleep(3000);

        driver.close();
        //driver.quit();

    }
}
