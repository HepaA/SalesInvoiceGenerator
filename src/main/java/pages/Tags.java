package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TagsPage {

    public WebDriver driver ;
    public TagsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By select= By.xpath("//div/ul[@class=\"product-tags-list\"]/li");
    public List<WebElement> select() {
      return driver.findElements(select);
    }
}
