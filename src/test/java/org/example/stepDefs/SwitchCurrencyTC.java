package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class SwitchCurrencyTC {
    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();

    @When("user click on currency bar")
    public void currencyBar() {
        homePage.currencyBar().click();
    }

    @And("choose different currency")
    public void switchCurrency() {
        homePage.switchCurrency().click();
    }

    @Then("currency will change")
    public void currencyCheck() throws InterruptedException {
        Thread.sleep(2_000);
        softAssert.assertTrue(homePage.selectedCurrency().getText().contains("Euro"));
        softAssert.assertAll();
    }
}
