package org.example.stepDefs;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.RegisterPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class RegisterTC {

    RegisterPage register = new RegisterPage();
    SoftAssert softAssert = new SoftAssert();

    @Given("user open browser and goes to register page")
    public void goToRegister(){
        register.registerPage().click();
    }

    @When("user selects gender type")
    public void selectGender(){
        register.selectGender().click();
    }

    @And("^user enters \"(.*)\" and \"(.*)\"$")
    public void userName(String first_name, String last_name){
        register.userName(first_name, last_name);
    }

    @And("user choose date of birth")
    public void birthDate(){
        register.birthDate();
    }

    @And("^user enters email address \"(.*)\"$")
    public void emailAddress(String email){
        register.emailAddress().sendKeys(email);
    }

    @And("^user enters password fields \"(.*)\"$")
    public void password(String password){
        register.password(password);
    }

    @And("user press on register")
    public void registerBtn(){
        register.registerBtn().click();
    }

    @Then("^register message is displayed \"(.*)\"$")
    public void registerMessage(String expectedMsg){
        String message = register.registerMessage().getText();
        softAssert.assertTrue(message.contains(expectedMsg));

        String text_color = register.registerMessage().getCssValue("color");
        softAssert.assertEquals("rgba(76, 177, 124, 1)", text_color);
        softAssert.assertAll();
    }
}
