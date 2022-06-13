package com.automation.step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Order;

public class CreateOrder {
    static Faker faker = new Faker();
    Order order = Base.pagebase.orderPage();

    @Given("go to shopping cart")
    public void go_to_shopping_cart() {

        Base.driver.navigate().to("https://demo.nopcommerce.com/apple-macbook-pro-13-inch");
        order.addProduct();
        order.open();
    }

    @And("accept the terms of service")
    public void accept_the_terms() {
       order.acceptTermsen();
    }

    @When("click on check out button")
    public void check_out() {
        order.checkout();
    }

    @And("Update address information")
    public void Update_address_information() {
        order.country(faker.address().country());
        order.city(faker.address().city());
        order.address(faker.address().streetAddress());
        order.zipCode(faker.address().zipCode());
        order.phoneNumber(faker.phoneNumber().phoneNumber());
        order.addressBtn();
    }

    @Then("confirm order")
    public void confirm_order() {
        order.confirmOrder();
    }

    @And("order completed successfully")
    public void order_completed() {
        String expectedResult = "Your order has been successfully processed!";
        String actualResult = order.orderCreatedSuccessfully();
        Assert.assertTrue(actualResult.contains(expectedResult), "confirm message");
    }

}