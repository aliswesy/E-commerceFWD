package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage {
    WebDriver driver = Hooks.driver;
    Actions action = new Actions(driver);

    /**
     * Search Product Test Case
     */
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

    /**
     * Switch Currency Test Case
     */
    //Find the currency bar
    public WebElement currencyBar() {
        return driver.findElement(By.id("customerCurrency"));
    }

    //return the not selected currency
    public WebElement switchCurrency(){
        WebElement us_dollar = driver.findElement(By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/1?returnUrl=%2F\"]"));
        WebElement euro = driver.findElement(By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]"));
        return us_dollar.isSelected() ? euro : us_dollar;

    }

    //return selected currency
    public WebElement selectedCurrency(){
        WebElement us_dollar = driver.findElement(By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/1?returnUrl=%2F\"]"));
        WebElement euro = driver.findElement(By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]"));
        return us_dollar.isSelected() ? us_dollar : euro;
    }

    //return a list of products
    public List<WebElement> item_box(){
        return driver.findElements(By.cssSelector("div[class=\"item-box\"]"));
    }

    /**
     * Category select methods
     */

    //return category
    public WebElement findCategory(String category){
        return driver.findElement(By.cssSelector("a[href=\"/"+ category.toLowerCase() + "\"]"));
    }

    //hover over selected category
    public void hoverCategory(String category){

       WebElement categoryElement = driver.findElement(By.cssSelector("a[href=\"/"+ category.toLowerCase() + "\"]"));
       action.moveToElement(categoryElement).perform();
    }

    //return sub category
    public WebElement findSubCategory(String sub_category){
        return driver.findElement(By.cssSelector("a[href=\"/"+ sub_category.toLowerCase() + "\"]"));
    }

    public WebElement categoryHead(){
        return driver.findElement(By.cssSelector("div[class=\"page-title\"]"));
    }
}
