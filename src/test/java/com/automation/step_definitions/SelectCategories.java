package com.automation.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.Categories;

import java.util.List;
import java.util.Random;

public class SelectCategories {
    Categories categories = Base.pagebase.categoriesPage();

   @When ("user enter to category page")
    public void enter_to_category_page() {
        List<WebElement> productElems = categories.go();
        // get the len of productElems
        int maxProducts = productElems.size();
        // get random number
        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);
       // Select the list item
       productElems.get(randomProduct).click();
    }

    @Then ("open sub-category")
    public void open_sub_category()  {

       String check = categories.check();
        System.out.println("text: " +check);
        if(check.contains("Computers")||check.contains("Electronics")||check.contains("Apparel")){

        List<WebElement> productElem =  categories.sub();
        int maxProducts = productElem.size();
        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);
        productElem.get(randomProduct).click();
        }

    }

}
