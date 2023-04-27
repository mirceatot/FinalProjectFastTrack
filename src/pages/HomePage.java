package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    //Locator for Login button
    By LoginBtn = By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/span/span/span/button");

    By WishlistIcon = By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/span/a[2]");

    By YourCart = By.xpath("//*[@id=\"responsive-navbar-nav\"]/div[2]/span/a[1]");

    By HighToLowPriceSort = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/form/div[2]/select/option[4]");


    //Method to click Login button
    public void clickLogin() {
        driver.findElement(LoginBtn).click();
    }
    //Method to click on Wishlist button
    public void clickWishlist(){
        driver.findElement(WishlistIcon).click();
    }
    //Method to click on Your Cart button
    public void clickOnYourCart(){
        driver.findElement(YourCart).click();
    }
    //Method to sort the prices from High to Low
    public void highToLowPriceSort(){
        driver.findElement(HighToLowPriceSort).click();
    }
}