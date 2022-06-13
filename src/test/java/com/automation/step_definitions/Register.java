package com.automation.step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Registration;

public class Register {
   //SoftAssert soft;
   static Faker faker = new Faker();
   public
   static String email = faker.name().firstName().toLowerCase()+"@domain.com" ;
   String pass = "P@ssw0rd";
   Registration registrationPage = Base.pagebase.registrationPage();

   @Given("user go to register page")
   public void go_to_register_page()  {
   //Base.driver.findElement(By.cssSelector("a[class=\"ico-register\"]")).click();

      registrationPage.go();
}

   @When("user enter a valid data")
   public void enter_a_valid_data() throws InterruptedException {
      registrationPage.fName(faker.name().firstName());
      registrationPage.lName(faker.name().lastName());
      registrationPage.email(email);
      registrationPage.password(pass);
      registrationPage.confirmPassword(pass);

      /*
      Base.driver.findElement(By.id("FirstName")).sendKeys(faker.name().firstName());
      Base.driver.findElement(By.id("LastName")).sendKeys(faker.name().lastName());

   Base.driver.findElement(By.id("Email")).sendKeys(email);

      Base.driver.findElement(By.id("Password")).sendKeys(pass);
      Base.driver.findElement(By.id("ConfirmPassword")).sendKeys(pass);
       */

   }

   @And("user press on register button")
   public void register_button()
   {
      registrationPage.btn();
      //Base.driver.findElement(By.id("register-button")).sendKeys(Keys.ENTER);
   }

   @Then("user register to the system successfully")
   public void success_register()
   {
      String expectedResult = "Your registration completed";
      //String actualResult = Base.driver.findElement(By.className("result")).getText();
      String actualResult = registrationPage.success();
      Assert.assertTrue(actualResult.contains(expectedResult),"confirm message");

   }
   @And("user logout")
   public void logout()
   {
      registrationPage.logout();
      //By logoutE = By.cssSelector("a[href=\"/logout\"]");
      //WebElement check = Base.driver.findElement(logoutE);
      //check.click();
   }

}
