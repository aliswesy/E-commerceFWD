package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    WebDriver driver = Hooks.driver;

    public WebElement registerPage(){
        return driver.findElement(By.className("ico-register"));
    }
}
