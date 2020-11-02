package com.motorola.stepdefinition;

import com.motorola.pom.ShoppingCartPageObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ShoppingCartSummaryStepDef  {

    ShoppingCartPageObject shoppingCartPageObject = new ShoppingCartPageObject();

    @And("^I mouse hover on the second product displayed\\.$")
    public void iMouseHoverOnTheSecondProductDisplayed() {
        shoppingCartPageObject.mouseHoverOnSecondElement();
    }

    @When("^'More' button will be displayed, click on 'More' button\\.$")
    public void more_button_will_be_displayed_click_on_More_button()  {
        shoppingCartPageObject.clickOnSecondProductMoreButton();
    }

    @And("^I Make sure the quantity is set to \"([^\"]*)\"\\.$")
    public void iMakeSureTheQuantityIsSetTo(String expectedQuantity)  {
        String actualQuantity = shoppingCartPageObject.readQuantity();
        //System.out.println("actualQuantity: "+actualQuantity);
        Assert.assertEquals(expectedQuantity,actualQuantity);
    }

    @And("^I Select product color.$")
    public void iSelectProductColor()  {
        shoppingCartPageObject.selectColor();
    }

    @And("^I Change the quantity to '(\\d+)'\\.$")
    public void iChangeTheQuantityTo(int arg0)  {
        shoppingCartPageObject.changeProductQuantity();
    }

    @Then("^Verify that Total price is changing and reflecting the correct price\\.$")
    public void verify_that_Total_price_is_changing_and_reflecting_the_correct_price()  {
        int quantityValue = shoppingCartPageObject.singleProductPrice();
        int updatedQuantityValue = shoppingCartPageObject.validateTheUpdatedPrice();
        int updatedQuantity = shoppingCartPageObject.getUpdatedQuantityValue();
        int updatedPrice = quantityValue * updatedQuantity;
        Assert.assertEquals(updatedQuantityValue,updatedPrice);
    }

}
