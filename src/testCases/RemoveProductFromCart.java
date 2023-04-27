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

public class RemoveProductFromCart {
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
    public void removeProductFromCart() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[3]/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"responsive-navbar-nav\"]/div[2]/span/a[1]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div/div/div[5]/button")).click();
        Assert.assertTrue(driver.getPageSource().contains("How about adding some products in your cart?"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
