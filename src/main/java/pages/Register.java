package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Registration {
    public WebDriver driver ;
    public Registration(WebDriver driver) {
        this.driver = driver;
    }

    private By go=  By.cssSelector("a[class=\"ico-register\"]");
    public void go(){
           driver.findElement(go).click();
       }

    private By fName=  By.id("FirstName");
    public void fName(String name){
        driver.findElement(fName).sendKeys(name);
    }
    private By lName=  By.id("LastName");
    public void lName(String name){
        driver.findElement(lName).sendKeys(name);
    }
    private By email=  By.id("Email");
    public void email(String mail){
        driver.findElement(email).sendKeys(mail);
    }
    private By password=  By.id("Password");
    public void password(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    private By confirmPassword=  By.id("ConfirmPassword");
    public void confirmPassword(String confirm){
        driver.findElement(confirmPassword).sendKeys(confirm);
    }
    private By btn=  By.id("register-button");
    public void btn(){
        driver.findElement(btn).sendKeys(Keys.ENTER);
    }
    private By success=  By.className("result");
    public String success(){
        return driver.findElement(success).getText();
    }
    private By logout=  By.cssSelector("a[href=\"/logout\"]");
    public void logout(){
         driver.findElement(logout).click();
    }

}
