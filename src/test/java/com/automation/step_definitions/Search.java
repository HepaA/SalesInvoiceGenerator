package com.automation.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Search {

    pages.Search searchPage = Base.pagebase.searchPage();

    @When("user clicks on search field")
    public void clicks_on_search_field()
    {
        // locate search field and click on it
        //Base.driver.findElement(By.id("small-searchterms")).click();
        searchPage.clickField();
    }

    @And("user search with name of product")
    public void search_with_product_name()
    {
        // Base.driver.findElement(By.id("small-searchterms")).sendKeys("book");
       // Base.driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]")).click();
        searchPage.typing();
        searchPage.searchBtn();
    }

    @Then("user could find relative results")
    public void find_relative_results()
    {    int count = Base.driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).size();
        //  int count = searchPage.driver.findElement(searchPage.result).size();
        //System.out.println(count);
        //Assert.assertTrue(count > 0);
        Assert.assertTrue(searchPage.result() > 0);
        // findelements     [webelement0, webelement1]
        for (int x = 0; x < count ; x++) {
            //System.out.println(Base.driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).get(x).getText());
            //Assert.assertTrue(Base.driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).get(x).getText().toLowerCase().contains("book"));
            Assert.assertTrue(searchPage.assertT());

        }
    }

    @Given ("user choose advanced search")
    public void advanced_search()
    {
        searchPage.advanced_search();
        //Base.driver.findElement(By.xpath("//div/input[@id=\"advs\"]")).click();
    }

    @When("user choose specific category")
    public void choose_category()
    {   WebElement el = searchPage.choose_category();

        //WebElement el = Base.driver.findElement(By.xpath("//div/select[@id=\"cid\"]"));
        Select sel = new Select(el);
        sel.selectByIndex(3);
    }

    @Then("user choose manufacturer")
    public void choose_manufacturer()
    {   WebElement el = searchPage.choose_manufacturer();
            //WebElement el = Base.driver.findElement(By.xpath("//div/select[@id=\"mid\"]"));
        Select sel = new Select(el);
        sel.selectByIndex(2);
    }
    @And("user click on search button")
    public void click_on_search_button() {
        searchPage.advanceBtn();
        //Base.driver.findElement(By.cssSelector("button[class=\"button-1 search-button\"]")).click();
    }

}
