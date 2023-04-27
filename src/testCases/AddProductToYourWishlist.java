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

public class AddProductToYourWishlist {
    private WebDriver driver;
    private HomePage home;
    private LoginPage login;

    @BeforeClass
    public void setUp() {
        System.setProperty("web-driver.chrome.driver", "pathToYour/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://fasttrackit-test.netlify.app/#/");
        home = new HomePage(driver);
    }
    @Test
    public void addProductToYourWishlist() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#root > div > div:nth-child(2) > div:nth-child(2) > div > div.col.col-lg-2.text-center.col > button:nth-child(3)")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/span/a[2]")).click();
        Assert.assertTrue(driver.getPageSource().contains("fa-layers-counter shopping_cart_badge"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
