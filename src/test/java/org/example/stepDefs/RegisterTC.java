package org.example.stepDefs;

import io.cucumber.java.en.Given;
import org.example.pages.RegisterPage;
import org.openqa.selenium.WebDriver;

public class RegisterTC {

    RegisterPage register = new RegisterPage();

    @Given("user open browser and goes to register page")
    public void goToRegister(){
        register.registerPage().click();
    }
}
