package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver = Hooks.driver;

    public WebElement loginPage(){
        return driver.findElement(By.cssSelector("a[href=\"/login?returnUrl=%2F\""));
    }

    //Enter Email and password
    public void emailAndPassword(String email, String password){
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
    }

    //Find login button
    public WebElement loginBtn(){
        return driver.findElement(By.cssSelector("div[class=\"buttons\"] > button[type=\"submit\"]"));
    }

    //successful login
    public String getUrl(){
        return driver.getCurrentUrl();
    }
    public WebElement myAccount(){
        return driver.findElement(By.cssSelector("a[href=\"/customer/info\"]"));
    }

    //failed login
    public WebElement failedLogin(){
        return driver.findElement(By.xpath("//form/div[1]"));
    }

}
