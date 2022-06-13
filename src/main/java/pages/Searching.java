package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search {

    public WebDriver driver ;
    public Search(WebDriver driver) {
        this.driver = driver;
    }

    private By clickField=  By.id("small-searchterms");
    public void clickField() {
        driver.findElement(clickField).click();
    }

    private By typing=  By.id("small-searchterms");
    public void typing() {
        driver.findElement(typing).sendKeys("book");
    }

    int count;
    private By result=  By.cssSelector("h2[class=\"product-title\"] a");
    public  int result() {
        count = driver.findElements(result).size();
        return count;
    }

    public  boolean assertT() {
        boolean temp = true;
        for (int x = 0; x < count; x++) {
          temp = driver.findElements(result).get(x).getText().toLowerCase().contains("book");
        }
        return temp;
    }

    private By searchBtn=  By.cssSelector("button[class=\"button-1 search-box-button\"]");
    public void searchBtn() {
        driver.findElement(searchBtn).click();
    }

    private By advanced_search=  By.xpath("//div/input[@id=\"advs\"]");
    public void advanced_search() {
        driver.findElement(advanced_search).click();
    }

    private By choose_category=  By.xpath("//div/select[@id=\"cid\"]");
    public WebElement choose_category() {
        return driver.findElement(choose_category);
    }

    private By choose_manufacturer=  By.xpath("//div/select[@id=\"mid\"]");
    public WebElement choose_manufacturer() {
        return driver.findElement(choose_manufacturer);
    }

    private By advanceBtn=  By.cssSelector("button[class=\"button-1 search-button\"]");
    public void advanceBtn() {
        driver.findElement(advanceBtn).click();
    }

}
