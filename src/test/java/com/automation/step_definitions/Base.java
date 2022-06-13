package com.automation.step_definitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageBase;

import java.util.concurrent.TimeUnit;

public class Base {
    static WebDriver driver;
    static PageBase pagebase;
    @BeforeAll
    public static void user_open_chrome_browser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
        pagebase = new PageBase(driver);
    }

    @AfterAll
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }



}
