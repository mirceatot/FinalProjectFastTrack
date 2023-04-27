package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locator for username field
    By userName = By.id("user-name");

    //Locator for password field
    By password = By.id("password");

    //Locator for login button
    By loginButton = By.xpath("/html/body/div[3]/div/div/div[2]/div/form/button");

    //Locator for logout button

    By logoutButton = By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/span/span/button");


    //Method to enter username
    public void enterUsername(String user) {
        driver.findElement(userName).sendKeys(user);
    }

    //Method to enter password
    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    //Method to click on Login button
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    //Method to click on Logout button
    public void clickLogout(){
        driver.findElement(logoutButton).click();
    }
}