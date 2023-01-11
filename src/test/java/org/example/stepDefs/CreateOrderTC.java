package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.HomePage;
import org.example.pages.ShoppingCart;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

public class CreateOrderTC {
    HomePage homePage = new HomePage();
    ShoppingCart shoppingCart = new ShoppingCart();
    SoftAssert softAssert = new SoftAssert();

    @And("goes to the shopping cart")
    public void goToShoppingCart(){
        homePage.findElementByHref("cart").click();
    }

    @And("press on agree to terms and press checkout")
    public void confirmOrder(){
        shoppingCart.agreement().click();
        shoppingCart.checkout().click();
    }

    @And("enter Billing address data")
    public void billingAddressData(){
        //pass country
        shoppingCart.billingFiled("CountryId").sendKeys("eg");
        shoppingCart.billingFiled("CountryId").sendKeys(Keys.RETURN);

        //pass city
        shoppingCart.billingFiled("City").sendKeys("cairo");

        //pass address 1
        shoppingCart.billingFiled("Address1").sendKeys("test Address");

        //pass zip
        shoppingCart.billingFiled("ZipPostalCode").sendKeys("0000");

        //pass phone number
        shoppingCart.billingFiled("PhoneNumber").sendKeys("0123456789");

        shoppingCart.billingButton().click();
    }

    @And("select shipping method")
    public void shippingMethod(){
        shoppingCart.shippingButton().click();
    }

    @And("select payment method")
    public void paymentMethod(){
        shoppingCart.paymentButton().click();
    }

    @And("confirm payment info method")
    public void paymentInfoMethod(){
        shoppingCart.paymentInfoButton().click();
    }

    @And("confirm order")
    public void conformOrderMethod(){
        shoppingCart.confirmButton().click();
    }

    @Then("confirmation message appear")
    public void confirmationMessage(){
        softAssert.assertTrue(shoppingCart.confirmationMessage().getText()
                .contains("Your order has been successfully processed!"));
        softAssert.assertAll();
    }
}
