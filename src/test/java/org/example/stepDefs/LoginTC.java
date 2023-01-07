package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.testng.asserts.SoftAssert;

public class LoginTC {
    LoginPage login = new LoginPage();
    SoftAssert softAssert = new SoftAssert();

    @Given("user goes to login page")
    public void goToLogin(){
        login.loginPage().click();
    }

    @When("^user enters data \"(.*)\" and \"(.*)\"$")
    public void emailAndPassword(String email, String password){
        login.emailAndPassword(email, password);
    }

    @And("user press on login")
    public void loginBtn(){
        login.loginBtn().click();
    }

    @Then("user login successfully")
    public void successLogin(){
        softAssert.assertEquals(login.getUrl(), "https://demo.nopcommerce.com/");
        softAssert.assertTrue(login.myAccount().isDisplayed());
        softAssert.assertAll();
    }

    @Then("user login failed")
    public void failedLogin(){
        softAssert.assertTrue(login.failedLogin().getText().contains("Login was unsuccessful."));
        softAssert.assertEquals(login.failedLogin().getCssValue("color"), "rgba(228, 67, 75, 1)");
        softAssert.assertAll();
    }

}
