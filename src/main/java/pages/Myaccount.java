package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MyAccount {

    public WebDriver driver ;
    public MyAccount(WebDriver driver) {
        this.driver = driver;
    }

    private By go=  By.cssSelector("a[class=\"ico-account\"]");
    public void go() {
        driver.findElement(go).click();
    }

    private By changePass=  By.cssSelector("a[href=\"/customer/changepassword\"]");
    public void changePass() {
        driver.findElement(changePass).click();
    }

    private By old=  By.id("OldPassword");
    public void old(String pass) {
        driver.findElement(old).sendKeys(pass);
    }

    private By newPass=  By.id("NewPassword");
    public void newPass() {
        driver.findElement(newPass).sendKeys("Passw0rd@");
    }

    private By confirm=  By.id("ConfirmNewPassword");
    public void confirm() {
        driver.findElement(confirm).sendKeys("Passw0rd@");
    }

    private By btn=  By.cssSelector("button[class=\"button-1 change-password-button\"]");
    public void btn(){
        driver.findElement(btn).sendKeys(Keys.ENTER);
    }

    private By asrt=  By.cssSelector("p[class=\"content\"]");
    public String asrt(){
       return driver.findElement(asrt).getText();
    }
}
