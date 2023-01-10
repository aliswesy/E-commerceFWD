package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.ResetPasswordPage;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class WishlistTC {
    HomePage homePage = new HomePage();
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
    SoftAssert softAssert = new SoftAssert();

    @When("user clicks on wishlist button")
    public void addToWishlist(){
        Random random = new Random();
        WebElement product = homePage.item_box().get(random.nextInt(2,homePage.item_box().size()));
        homePage.addToWishlist(product).click();
    }

    @And("goes to wishlist page")
    public void goToWishlistPage() throws InterruptedException {
        homePage.findElementByHref("wishlist").click();
        Thread.sleep(2_000);
    }

    @Then("item is added to wishlist")
    public void wishlistCheck(){
        softAssert.assertTrue(homePage.findElementInWishlist().isDisplayed());
        softAssert.assertAll();
    }
}
