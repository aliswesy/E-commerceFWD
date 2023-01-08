package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.ResetPasswordPage;
import org.testng.asserts.SoftAssert;

public class ResetPasswordTC {
    ResetPasswordPage resetPassword = new ResetPasswordPage();
    SoftAssert softAssert = new SoftAssert();

    @Given("user goes to reset password page")
    public void goToResetPassword(){
        resetPassword.resetPasswordPage();
    }

    @When("^user enters his/her email \"(.*)\"$")
    public void enterEmail(String email){
        resetPassword.emailAddress().sendKeys(email);
    }

    @And("press recover")
    public void recoverBtn() throws InterruptedException {
        resetPassword.recoverBtn();
        Thread.sleep(2_000);
    }

    @Then("confirmation message is displayed")
    public void confirmMessage(){
        softAssert.assertTrue(resetPassword.confirmMessage().getText().contains("Email with instructions has been sent to you."));
        softAssert.assertAll();
    }
}
