package com.automation.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MyAccount;

public class ResetPassword {
    static Register R = new Register();
    MyAccount myAccountPage = Base.pagebase.myAccountPage();

    @Given("user go to account page")
    public void go_to_account_page()  {
       // Base.driver.findElement(By.cssSelector("a[class=\"ico-account\"]")).click();
        myAccountPage.go();
    }

    @And("user choose change password")
    public void choose_change_password()  {
      //  Base.driver.findElement(By.cssSelector("a[href=\"/customer/changepassword\"]")).click();
    myAccountPage.changePass();
    }

    @When ("user enter new password")
    public void enter_a_valid_data() {
        // Base.driver.findElement(By.id("OldPassword")).sendKeys(R.pass);
        // Base.driver.findElement(By.id("NewPassword")).sendKeys("Passw0rd@");
        // Base.driver.findElement(By.id("ConfirmNewPassword")).sendKeys("Passw0rd@");
        myAccountPage.old(R.pass);
        myAccountPage.newPass();
        myAccountPage.confirm();
    }

    @And("user press on change password button")
    public void register_button()
    {
        //Base.driver.findElement(By.cssSelector("button[class=\"button-1 change-password-button\"]")).sendKeys(Keys.ENTER);
        myAccountPage.btn();
    }

    @Then("user changed password successfully")
    public void success_register() {
        String expectedResult = "Password was changed";
        String actualResult = myAccountPage.asrt();
        Assert.assertTrue(actualResult.contains(expectedResult), "change password error");
    }
    }
