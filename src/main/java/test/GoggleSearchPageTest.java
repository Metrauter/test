package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;
import pages.GoogleSearchPageObjects;

public class GoggleSearchPageTest {

    private static WebDriver driver = null;

    public static void main(String[] args) {

        googleSearchTest();

    }

    public static void googleSearchTest(){

        String projectLocation = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);

        driver.get("https://google.com");

        searchPageObj.setTextInSearchBox("A B C D");

        searchPageObj.clickSearchButton();

        driver.close();
    }

}
