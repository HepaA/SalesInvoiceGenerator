package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class PageBase {
    protected WebDriver driver;
    public JavascriptExecutor jse;
    public Select select;
    public Actions actions;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected static void clickOnElement(WebElement element) {
        element.click();
    }

    protected static void setTxtElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected static void clearTxtElement(WebElement element){
        element.clear();
    }

    protected static void openPage(WebElement pageLink) {
        pageLink.click();
    }

    public void scrollTo(String scroll) {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("scrollBy(0," + scroll + ")");
    }
//0
    public LoginPage loginpage(){
        return new LoginPage(driver);
    }

    public Registration registrationPage(){
        return new Registration(driver);
    }

    public MyAccount myAccountPage(){
        return new MyAccount(driver);
    }

    public Search searchPage(){
        return new Search(driver);
    }

    public Wishlist wishlistPage(){ return new Wishlist(driver); }

    public FilterWithColor filterWithColorPage(){ return new FilterWithColor(driver); }

    public Categories categoriesPage(){ return new Categories(driver); }

    public Currencies currenciesPage(){ return new Currencies(driver); }

    public TagsPage tagsPage(){ return new TagsPage(driver); }

    public CompareList compareListPage(){ return new CompareList(driver); }

    public Cart cartPage(){ return new Cart(driver); }

    public Order orderPage(){ return new Order(driver); }

}
