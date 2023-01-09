package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.asserts.SoftAssert;

public class CategorySelectTC {
    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();

    @When("^user hover over a \"(.*)\"$")
    public void categoryHover(String category){
        homePage.findCategory(category);
    }

    @And("^select \"(.*)\" or \"(.*)\"$")
    public void selectedCategory(String category, String sub_category){
        homePage.hoverCategory(category);

        if (!sub_category.isEmpty()){
            homePage.findSubCategory(sub_category).click();
        }
        else
            homePage.findCategory(category).click();
    }

    @Then("^\"(.*)\" or \"(.*)\" heading are displayed$")
    public void categoryHeading(String category, String sub_category) throws InterruptedException {
        Thread.sleep(2_000);

        String categoryHead = homePage.categoryHead().getText();
        if (sub_category.isEmpty())
            softAssert.assertEquals(homePage.categoryHead().getText(), category);
        else
            softAssert.assertEquals(homePage.categoryHead().getText(), sub_category);

        softAssert.assertAll();
    }
}
