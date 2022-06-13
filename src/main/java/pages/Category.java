package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Categories {

    public WebDriver driver ;
    public Categories(WebDriver driver) {
        this.driver = driver;
    }

    private By go=  By.xpath("//div/ul[@class=\"top-menu notmobile\"]/li/a");
    public List<WebElement> go() {
        return driver.findElements(go);
    }

    private By check= By.xpath("//div/div[@class=\"page-title\"]/h1");
    public String check() {
        return driver.findElement(check).getText();
    }

    private By sub= By.xpath("//div [@class=\"sub-category-item\"]");
    public  List<WebElement> sub() {
        return driver.findElements(sub);
    }
}
