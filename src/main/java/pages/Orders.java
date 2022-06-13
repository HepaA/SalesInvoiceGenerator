package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Order {

    public WebDriver driver ;
    public Order(WebDriver driver) {
        this.driver = driver;
    }

    private By addProduct= By.xpath("//div/button[@id=\"add-to-cart-button-4\"]");
    public void addProduct() {
        driver.findElement(addProduct).click();
    }

    private By open= By.cssSelector("a[href=\"/cart\"]");
    public void open() {
        driver.findElement(open).click();
    }

    private By acceptTerms= By.xpath("//div/input[@ id=\"termsofservice\"]");
    public void acceptTermsen() {
        driver.findElement(acceptTerms).click();
    }

    private By checkout= By.xpath("//div/button[@id=\"checkout\"]");
    public void checkout() {
        driver.findElement(checkout).click();
    }

    private By country= By.cssSelector("select[id=\"BillingNewAddress_CountryId\"]");
    public void country(String x) {
        driver.findElement(country).sendKeys(x);
    }

    private By city= By.cssSelector("input[id=\"BillingNewAddress_City\" ]");
    public void city(String x) {
        driver.findElement(city).sendKeys(x);
    }

    private By address= By.cssSelector("input[id=\"BillingNewAddress_Address1\" ]");
    public void address(String x) {
        driver.findElement(address).sendKeys(x);
    }

    private By zipCode= By.cssSelector("input[id=\"BillingNewAddress_ZipPostalCode\" ]");
    public void zipCode(String x) {
        driver.findElement(zipCode).sendKeys(x);
    }

    private By phoneNumber= By.cssSelector("input[id=\"BillingNewAddress_PhoneNumber\" ]");
    public void phoneNumber(String x) {
        driver.findElement(phoneNumber).sendKeys(x);
    }

    private By addressBtn= By.xpath("//div/button[@class=\"button-1 new-address-next-step-button\"] ");
    public void addressBtn() {
        driver.findElement(addressBtn).click();
    }

    private By shippingMethod= By.xpath("//div/button[@class=\"button-1 shipping-method-next-step-button\"] ");
    private By paymentMethod= By.xpath("//div/button[@class=\"button-1 payment-method-next-step-button\"] ");
    private By paymentInfo= By.xpath("//div/button[@class=\"button-1 payment-info-next-step-button\"] ");
    private By confirmOrder= By.xpath("//div/button[@class=\"button-1 confirm-order-next-step-button\"] ");
    public void confirmOrder() {
        driver.findElement(shippingMethod).click();
        driver.findElement(paymentMethod).click();
        driver.findElement(paymentInfo).click();
        driver.findElement(confirmOrder).click();
    }

    private By orderCreatedSuccessfully= By.cssSelector("div[class=\"section order-completed\"]");
    public String orderCreatedSuccessfully() {
        return driver.findElement(orderCreatedSuccessfully).getText();
    }

}
