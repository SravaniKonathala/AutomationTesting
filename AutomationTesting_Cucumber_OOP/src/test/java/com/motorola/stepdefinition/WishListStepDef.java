package com.motorola.stepdefinition;

import com.motorola.pom.WishListPageObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class WishListStepDef {
    WishListPageObject wishListPageObject = new WishListPageObject();

    @Given("^I Make sure you are not logged in with any user\\. If yes, please, proceed with the ‘Sign out’\\.$")
    public void i_Make_sure_you_are_not_logged_in_with_any_user_If_yes_please_proceed_with_the_Sign_out() {
        Assert.assertTrue(wishListPageObject.isSignInButtonPresent());
        //System.out.println("Element is Enabled");
    }

    @When("^I Mouse hover on the first product displayed\\.$")
    public void i_Mouse_hover_on_the_first_product_displayed() {
        wishListPageObject.mouseOverToFirstProduct();
    }

    @When("^I 'Add to Wishlist' will appear on the bottom of that product, click on it\\.$")
    public void i_Add_to_Wishlist_will_appear_on_the_bottom_of_that_product_click_on_it() {
        wishListPageObject.clickOnWishList();
    }

    @Then("^I Verify that the error message is displayed \"([^\"]*)\"$")
    public void i_Verify_that_the_error_message_is_displayed(String ExpectedErrorMsg) {
        String actualErrorMsgText;
        actualErrorMsgText = wishListPageObject.handelSignInAlert();
        Assert.assertEquals(ExpectedErrorMsg,actualErrorMsgText );
       // System.out.println("actualErrorMsgText: "+actualErrorMsgText);
    }

    @When("^I 'Add to Wishlist' will appear on the bottom of second product, click on it\\.$")
    public void i_Add_to_Wishlist_will_appear_on_the_bottom_of_second_product_click_on_it() {
        //Implemented on mouse hover
    }

    @When("^I Mouse hover on the second product displayed\\.$")
    public void i_Mouse_hover_on_the_second_product_displayed()  {
        wishListPageObject.clickOnSecondProduct();
    }

    @Then("^I Verify if the product is on your Whishlist under My account > My wishlists$")
    public void i_Verify_if_the_product_is_on_your_Whishlist_under_My_account_My_wishlists() {
        wishListPageObject.addWishListSuccessMsg();
    }
}
