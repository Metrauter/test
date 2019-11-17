import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSeleniumTest {
    public static void main(String[] args) {
        String projectLocation = System.getProperty("user.dir");

        //System.setProperty("webdriver.gecko.driver","C:\\Users\\Serhii\\IdeaProjects\\test\\lib\\geckodriver\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://zk.fm");
        //driver.quit();
    }


}
