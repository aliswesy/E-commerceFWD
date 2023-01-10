package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.ResetPasswordPage;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class CompareListTC {
    HomePage homePage = new HomePage();
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
    SoftAssert softAssert = new SoftAssert();

    @When("user clicks on compare button")
    public void addToCompareList(){
        Random random = new Random();
        WebElement product = homePage.item_box().get(random.nextInt(homePage.item_box().size()));
        homePage.addToCompareList(product).click();
    }

    @Then("item is added to compare list and display message appear")
    public void compareCheck(){
        softAssert.assertTrue(resetPasswordPage.confirmMessage().getText()
                .contains("The product has been added to your product comparison"));
        softAssert.assertAll();
    }
}
