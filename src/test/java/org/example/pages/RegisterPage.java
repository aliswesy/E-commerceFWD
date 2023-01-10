package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver = Hooks.driver;

    public WebElement registerPage(){
        return driver.findElement(By.className("ico-register"));
    }

    public WebElement selectGender(){
        return driver.findElement(By.id("gender-male"));
    }

    //Enter username
    public WebElement firstName(){
        return driver.findElement(By.id("FirstName"));
    }

    public WebElement lastName(){
        return driver.findElement(By.id("LastName"));
    }

    //send first name and last name to the register page
    public void userName(String first_name, String last_name){
        firstName().sendKeys(first_name);
        lastName().sendKeys(last_name);
    }

    //Select date of birth
    public void birthDate(){
        driver.findElement(By.xpath("//select[1]/option[@value=\"30\"]")).click();
        driver.findElement(By.xpath("//select[2]/option[@value=\"1\"]")).click();
        driver.findElement(By.xpath("//select[3]/option[@value=\"1995\"]")).click();
    }

    //Enter Email Address
    public WebElement emailAddress(){
        return driver.findElement(By.id("Email"));
    }

    //Enter password and confirm password
    public void password(String password){
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
    }

    //Find register button
    public WebElement registerBtn(){
        return driver.findElement(By.id("register-button"));
    }

    public WebElement registerMessage(){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver ->driver.findElement(By.cssSelector("div[class=\"result\"]")));

    }
}
