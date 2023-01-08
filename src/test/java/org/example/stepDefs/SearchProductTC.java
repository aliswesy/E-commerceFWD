package org.example.stepDefs;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.asserts.SoftAssert;

public class SearchProductTC {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();

    @Given("^user is logged in \"(.*)\" and \"(.*)\"$")
    public void loggedUser(String email, String password){
        loginPage.loggedUser(email, password);
    }

    @When("^user goes to search bar and enters \"(.*)\"$")
    public void searchbar(String text){
        homePage.searchBar().sendKeys(text);
    }

    @And("user clicks on search")
    public void searchBtn(){
        homePage.searchBtn().click();
    }

    @Then("search result will appear")
    public void searchResult(){
        softAssert.assertTrue(homePage.searchUrl().contains("https://demo.nopcommerce.com/search?q="));
        System.out.println(homePage.searchCount());

        softAssert.assertAll();
    }

    @But("search word can't be less than 3 letters")
    public void searchCheck(){
        if (homePage.searchCheck() != null){
            softAssert.assertEquals(homePage.searchCheck().getText(), "Search term minimum length is 3 characters");
        }
    }
}
