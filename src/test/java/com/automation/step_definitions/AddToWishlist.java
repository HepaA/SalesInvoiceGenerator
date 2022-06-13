package com.automation.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Wishlist;

import java.util.List;
import java.util.Random;

public class AddToWishlist {
    Wishlist wishlist = Base.pagebase.wishlistPage();

    @Given("user could select a product")
        public void select_a_product(){
        //        Hooks.driver.findElement(By.cssSelector("div[class=\"buttons\"] [class=\"button-2 add-to-wishlist-button\"]")).click();
        //div/button[@class=\"button-2 add-to-wishlist-button\"]//div [@class=\"product-grid home-page-product-grid\"]/div/div/div
       /* by search
            public void search_with_product_name()
    {
        Hooks.driver.findElement(By.id("small-searchterms")).click();
        Hooks.driver.findElement(By.id("small-searchterms")).sendKeys("book");
        Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]")).click();
    }
        */
        List<WebElement> productElem = wishlist.selectProduct();
        int maxProducts = productElem.size();
        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);
        productElem.get(randomProduct).click();
 }

    @When("user can add product to Wishlist")
    public void add_product_to_Wishlist() {
        //        Hooks.driver.findElements(By.xpath("//div /button [@class=\"button-2 add-to-wishlist-button\"]"));
        wishlist.btn();
    }

    @Then("product added to Wishlist successfully")
    public void product_added_to_Wishlist_successfully()
    {
        String expectedResult = "The product has been added to your wishlist";
        String actualResult = wishlist.addProductSuccessfully();
        Assert.assertTrue(actualResult.contains(expectedResult),"confirm message");
    }

}
