package com.automation.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import pages.PageBase;
public class Helper extends PageBase {

        public Helper(WebDriver driver) {
            super(driver);
        }

        public static void captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("./screenshots/" + screenshotName + ".png"));
        }


}
