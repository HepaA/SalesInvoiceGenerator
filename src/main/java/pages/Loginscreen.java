package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {

public WebDriver driver ;
    //2
    private By go = By.cssSelector("a[href=\"/login?returnUrl=%2F\"]");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By loginButton = By.className("login-button");
    private By checkLogin = By.cssSelector("a[href=\"/logout\"]");

    //1
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //3
    public void go(){
        driver.findElement(go).click();
    }

    public void usernamePassword(String e,String pass){
        driver.findElement(email).sendKeys(e);
        driver.findElement(password).sendKeys(pass);
    }
    public void loginbtn (){

        driver.findElement(loginButton).sendKeys(Keys.ENTER);

    }
    public boolean loginSuccess(){

        return driver.findElement(checkLogin).isDisplayed();

    }
}
