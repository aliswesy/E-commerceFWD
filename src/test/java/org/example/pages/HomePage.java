package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    WebDriver driver = Hooks.driver;
    Actions action = new Actions(driver);

    /**
     * Search Product Test Case
     */
    //find search bar
    public WebElement searchBar() {
        return driver.findElement(By.id("small-searchterms"));
    }

    //search button
    public WebElement searchBtn() {
        return driver.findElement(By.cssSelector("button[type=\"submit\"]"));
    }

    public String searchUrl() {
        return driver.getCurrentUrl();
    }

    public int searchCount() {
        int count;
        if (driver.findElement(By.cssSelector("div[class=\"item-box\"]")).isDisplayed()) {
            count = driver.findElements(By.cssSelector("div[class=\"item-box\"]")).size();
        } else count = 0;

        return count;
    }

    public WebElement searchCheck() {
        if (driver.findElement(By.cssSelector("div[class=\"item-box\"]")).isDisplayed()) {
            return null;
        } else return driver.findElement(By.cssSelector("div[class=\"warning\"]"));
    }

    /**
     * Switch Currency Test Case
     */
    //Find the currency bar
    public WebElement currencyBar() {
        return driver.findElement(By.id("customerCurrency"));
    }

    //return the not selected currency
    public WebElement switchCurrency() {
        WebElement us_dollar = driver.findElement(By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/1?returnUrl=%2F\"]"));
        WebElement euro = driver.findElement(By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]"));
        return us_dollar.isSelected() ? euro : us_dollar;

    }

    //return selected currency
    public WebElement selectedCurrency() {
        WebElement us_dollar = driver.findElement(By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/1?returnUrl=%2F\"]"));
        WebElement euro = driver.findElement(By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]"));
        return us_dollar.isSelected() ? us_dollar : euro;
    }

    //return a list of displayed products
    public List<WebElement> item_box() {
        List<WebElement> displayed_items = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class=\"item-box\"]")));
//                driver.findElements(By.cssSelector("div[class=\"item-box\"]"));
        displayed_items.removeIf(item -> !item.isDisplayed());
        return displayed_items;
    }

    /**
     * Category select methods
     */

    //return an element with the passed href passed
    public WebElement findElementByHref(String name) {
        return driver.findElement(By.cssSelector("a[href=\"/" + name.toLowerCase() + "\"]"));
    }

    //hover over selected category
    public void hoverCategory(String category) {

        WebElement categoryElement = driver.findElement(By.cssSelector("a[href=\"/" + category.toLowerCase() + "\"]"));
        action.moveToElement(categoryElement).perform();
    }

    //Return the text of the page title
    public String pageTitle() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.cssSelector("div[class=\"page-title\"]")).getText());
    }

    /**
     * Filter by color methods
     */

    //find color
    public WebElement findColor(String color) {
        List<WebElement> colors = driver.findElements(By.cssSelector("li[class=\"item" + " " + "color-item\"]"));
        for (WebElement colorElement :
                colors) {
            if (colorElement.getText().contains(color))
                return colorElement;
        }
        return colors.get(0);
    }


    //returns a list of item's popular tags
    public List<WebElement> itemPopularTags(){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElements(By.cssSelector("li[class=\"tag\"]")));
    }

    //returns element product tag list
    public WebElement productTagList(){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.cssSelector("div[class=\"product-tags-list\"]")));
    }

}
