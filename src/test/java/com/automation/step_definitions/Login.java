package com.automation.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

public class Login {
    /*SoftAssert soft;
    By logoutE = By.cssSelector("a[href=\"/logout\"]");
    WebElement check = Hooks.driver.findElement(logoutE);
    @Before
    public void login_chick()
    {
         if (check.isDisplayed())
             check.click();
    }
     */
    static Register R = new Register();
    //4
    LoginPage loginPage = Base.pagebase.loginpage();
    @Given("user go to login page")
    public void go_to_login_page() throws InterruptedException {
     //5
     loginPage.go();
    //Base.driver.findElement(By.cssSelector("a[href=\"/login?returnUrl=%2F\"]")).click();
    }

    @When("user login with valid email and password")
    public void valid_username_password( )
    {
        loginPage.usernamePassword(R.email,R.pass);
      //  Base.driver.findElement(By.id("Email")).sendKeys(R.email);
      //  Base.driver.findElement(By.id("Password")).sendKeys(R.pass);
    }

    @And("user press on login button")
    public void login_button()
    {
        loginPage.loginbtn();
        //Base.driver.findElement(By.className("login-button")).sendKeys(Keys.ENTER);

    }

    @Then("user login to the system successfully")
    public void success_login()
    {
        Assert.assertTrue( loginPage.loginSuccess());
        //Assert.assertTrue( Base.driver.findElement(By.cssSelector("a[href=\"/logout\"]")).isDisplayed());

    }
    @After
    public static void sleepDriver() throws InterruptedException {
        Thread.sleep(4000);
    }
}
