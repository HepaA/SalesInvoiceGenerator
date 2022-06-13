package com.automation.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CompareList;

import java.util.List;
import java.util.Random;

public class AddToCompareList {
    CompareList compare = Base.pagebase.compareListPage();

    @Given("user select a product")
    public void select_a_product(){

        List<WebElement> productElem = compare.select();
        int maxProducts = productElem.size();
        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);
        productElem.get(randomProduct).click();

    }

    @When("user can add product to compare list")
    public void add_product_to_compare_list(){
        compare.addProduct();
    }

    @Then("product added to compare list successfully")
    public void product_added_to_compare_list_successfully()
    {
        String expectedResult = "The product has been added to your product comparison";
        String actualResult = compare.addedSuccessfully();
        Assert.assertTrue(actualResult.contains(expectedResult),"confirm message");
    }

}
