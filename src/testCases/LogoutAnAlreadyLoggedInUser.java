package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LogoutAnAlreadyLoggedInUser {
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
    public void logoutAnAlreadyLoggedInUser() throws InterruptedException{
        home.clickLogin();
        login.enterUsername("dino");
        login.enterPassword("choochoo");
        login.clickLogin();
        Thread.sleep(3000);
        login.clickLogout();
        Assert.assertTrue(driver.getPageSource().contains("Hello guest! "));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}