package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class SortPriceHighToLow {
    private WebDriver driver;
    private HomePage home;
    private LoginPage login;

    @BeforeClass
    public void setUp() {
        System.setProperty("web-driver.chrome.driver", "\"C:\\Users\\florin.stefan\\Desktop\\fasttrackit\\QA 32\\chromedriver_win32\\chromedriver.exe\"");
        driver = new ChromeDriver();
        driver.get("https://fasttrackit-test.netlify.app/#/");
        home = new HomePage(driver);
    }
    @Test
    public void sortPriceHighToLow() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/form/div[2]/select")).click();
        Thread.sleep(3000);
        home.highToLowPriceSort();
        Assert.assertTrue(driver.getPageSource().contains("29.99"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
