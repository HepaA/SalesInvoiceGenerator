package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CompareList {

    public WebDriver driver ;
    public CompareList(WebDriver driver) {
        this.driver = driver;
    }

    private By select= By.xpath("//div [@class=\"product-item\"] ");
    public List<WebElement> select() {
        return driver.findElements(select);
    }

    private By addProduct= By.className("compare-products");
    public void addProduct() {
        driver.findElement(addProduct).click();
    }

    private By addedSuccessfully= By.cssSelector("p[class=\"content\"]");
    public String addedSuccessfully() {
        return driver.findElement(addedSuccessfully).getText();
    }

}