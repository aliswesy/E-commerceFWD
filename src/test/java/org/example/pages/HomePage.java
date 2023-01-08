package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    WebDriver driver = Hooks.driver;

    //find search bar
    public WebElement searchBar(){
        return driver.findElement(By.id("small-searchterms"));
    }

    //search button
    public WebElement searchBtn(){
        return driver.findElement(By.cssSelector("button[type=\"submit\"]"));
    }

    public String searchUrl(){
        return driver.getCurrentUrl();
    }

    public int searchCount(){
        int count;
        if (driver.findElement(By.cssSelector("div[class=\"item-box\"]")).isDisplayed()) {
            count = driver.findElements(By.cssSelector("div[class=\"item-box\"]")).size();
        }
        else count = 0;

        return count;
    }

    public WebElement searchCheck(){
        if (driver.findElement(By.cssSelector("div[class=\"item-box\"]")).isDisplayed()){
        return null;}
        else return driver.findElement(By.cssSelector("div[class=\"warning\"]"));
    }

}
