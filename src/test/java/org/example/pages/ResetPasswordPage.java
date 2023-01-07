package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResetPasswordPage {
    WebDriver driver = Hooks.driver;

    //go to Reset password page
    public void resetPasswordPage(){
        driver.findElement(By.cssSelector("a[href=\"/login?returnUrl=%2F\"")).click();
        driver.findElement(By.cssSelector("a[href=\"/passwordrecovery\"")).click();
    }

    //find email element
    public WebElement emailAddress(){
        return driver.findElement(By.id("Email"));
    }

    //click recover button
    public void recoverBtn(){
        driver.findElement(By.name("send-email")).click();
    }

    public WebElement confirmMessage(){
        return driver.findElement(By.cssSelector("p[class=\"content\"]"));
    }
}
