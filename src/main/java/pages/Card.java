package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {

    public WebDriver driver ;
    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    private By addProduct= By.xpath("//div/button[@id=\"add-to-cart-button-4\"]");
    public void addProduct() {
        driver.findElement(addProduct).click();
    }

    private By addedSuccessfully= By.cssSelector("p[class=\"content\"]");
    public String addedSuccessfully() {
        return driver.findElement(addedSuccessfully).getText();
    }

    private By open= By.cssSelector("a[href=\"/cart\"]");
    public void open() {
        driver.findElement(open).click();
    }

    private By changeQuantity= By.xpath("//td[@class=\"quantity\"]/input[@class=\"qty-input\"] ");
    public void changeQuantity() {
        driver.findElement(changeQuantity).clear();
        driver.findElement(changeQuantity).click();
        driver.findElement(changeQuantity).sendKeys("4");
    }

    //private By delete= By.cssSelector("td[class=\"remove-from-cart\"]");
    private By delete= By.xpath("//table[@class=\"cart\"]/tbody/tr/td[@class=\"remove-from-cart\"]/button");
    public void delete() {
        driver.findElement(delete).click();
    }

    private By assertT= By.cssSelector("div[class=\"no-data\"]");
    public boolean assertT(String txt) {
        return driver.findElement(assertT).getText().contains(txt);
    }

}
