package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCart {
    WebDriver driver = Hooks.driver;

    //return the "i agree" element
    public WebElement agreement(){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.id("termsofservice")));
    }

    public WebElement checkout(){
        return driver.findElement(By.id("checkout"));
    }

    //return the filed for the passed field name
    public WebElement billingField(String name){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.id("BillingNewAddress_" + name)));
    }

    public WebElement billingButton(){
        return driver.findElement(By.name("save"));
    }

    public WebElement shippingButton(){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.cssSelector("button[class=\"button-1 shipping-method-next-step-button\"")));
    }

    public WebElement paymentButton(){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.cssSelector("button[class=\"button-1 payment-method-next-step-button\"")));
    }

    public WebElement paymentInfoButton(){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.cssSelector("button[class=\"button-1 payment-info-next-step-button\"")));
    }

    public WebElement confirmButton(){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.cssSelector("button[class=\"button-1 confirm-order-next-step-button\"")));
    }

    //conformation message
    public WebElement confirmationMessage(){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.cssSelector("div[class=\"section order-completed\"]")));
    }

}
