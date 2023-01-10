package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.testng.asserts.SoftAssert;

public class CategorySelectTC {
    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();

    @When("^user hover over a \"(.*)\"$")
    public void categoryHover(String category){
        homePage.findElementByHref(category);
    }

    @And("^select \"(.*)\" or \"(.*)\"$")
    public void selectedCategory(String category, String sub_category){
        homePage.hoverCategory(category);

        if (!sub_category.isEmpty()){
            homePage.findElementByHref(sub_category).click();
        }
        else
            homePage.findElementByHref(category).click();
    }

    @Then("^\"(.*)\" or \"(.*)\" heading are displayed$")
    public void categoryHeading(String category, String sub_category) throws InterruptedException {
        Thread.sleep(2_000);

        String categoryHead = homePage.pageTitle();
        if (sub_category.isEmpty())
            softAssert.assertEquals(homePage.pageTitle(), category);
        else
            softAssert.assertEquals(homePage.pageTitle(), sub_category);

        softAssert.assertAll();
    }
}
