package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterWithColor {

    private WebDriver driver;
    public FilterWithColor(WebDriver driver) {
        this.driver = driver;
    }

    private By go=  By.linkText("Apparel");
    public void go() {
        driver.findElement(go).click();
    }

    private By selectSub=  By.linkText("Shoes");
    public void selectSub() {
        driver.findElement(selectSub).click();
    }

    private By btn=  By.id("attribute-option-15");
    public void btn() {
        driver.findElement(btn).click();
    }

}
