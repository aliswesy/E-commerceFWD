package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class TagSelectTC {
    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();

    @When("^user press on a tag \"(.*)\"$")
    public void selectTag(String tag){
        homePage.findElementByHref(tag).click();
    }

    /**
     * this will select a random item and check if the tag is available in the product
     * @param tag
     */
    @Then("^items with the same tag \"(.*)\" will appear$")
    public void checkRandomItem(String tag){
        softAssert.assertTrue(homePage.pageTitle().contains(tag));

        Random random = new Random();
        homePage.item_box().get(random.nextInt(homePage.item_box().size())).click();
        softAssert.assertTrue(homePage.productTagList().getText().contains(tag));
    }
}
