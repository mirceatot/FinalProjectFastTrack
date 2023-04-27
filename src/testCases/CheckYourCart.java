package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class CheckYourCart {
    private WebDriver driver;
    private HomePage home;
    private LoginPage login;

    @BeforeClass
    public void setUp() {
        System.setProperty("web-driver.chrome.driver", "\"C:\\Users\\Orange\\Downloads\\chromedriver.exe\"");
        driver = new ChromeDriver();
        driver.get("https://fasttrackit-test.netlify.app/#/");
        home = new HomePage(driver);
    }
    @Test
    public void checkYourCart() throws InterruptedException{
        home.clickOnYourCart();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains("Your cart"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

