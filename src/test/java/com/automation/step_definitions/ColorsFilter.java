package com.automation.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FilterWithColor;

public class ColorsFilter {
    FilterWithColor filter = Base.pagebase.filterWithColorPage();

    @Given("user go to category page")
    public void go_to_category_page()  {
        filter.go();
    }

    @When("user select sub-category")
    public void select_sub_category()  {
        filter.selectSub();
    }

    @Then("user filter products by color")
    public void filter_products_by_color()  {
        filter.btn();
    }

}
