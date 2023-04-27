package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginWithLockedOutUser {
    private WebDriver driver;
    private HomePage home;
    private LoginPage login;

    @BeforeClass
    public void setUp() {
        System.setProperty("web-driver.chrome.driver", "pathToYour/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://fasttrackit-test.netlify.app/#/");
        home = new HomePage(driver);
        login = new LoginPage(driver);
    }
    @Test
    public void loginWithLockedOutUser() throws InterruptedException{
        home.clickLogin();
        login.enterUsername("locked");
        login.enterPassword("choochoo");
        login.clickLogin();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains("The user has been locked out."));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}