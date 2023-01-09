package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.testng.asserts.SoftAssert;

public class ColorFilterTC {
    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();

    @When("^user filter with color \"(.*)\"$")
    public void selectColor(String color){
        homePage.findColor(color).click();
    }

    @Then("^only \"(.*)\" displayed items will appear$")
    public void filterCount(String num) throws InterruptedException {
        Thread.sleep(2_000);
        int count = Integer.parseInt(num);
        softAssert.assertEquals(homePage.item_box().size(), count);
        softAssert.assertAll();

    }
}
