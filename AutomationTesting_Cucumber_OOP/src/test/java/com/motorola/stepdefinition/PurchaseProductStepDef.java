package com.motorola.stepdefinition;

import com.motorola.pom.PurchaseProductPageObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class PurchaseProductStepDef {
    PurchaseProductPageObject purchase = new PurchaseProductPageObject();

    @When("^I Login to the website \"([^\"]*)\" and \"([^\"]*)\"\\.$")
    public void i_Login_to_the_website_and(String username, String password)  {
        //System.out.println("username: "+username);
        purchase.login(username,password);
    }

    @When("^I Move the cursor over Women's link\\.$")
    public void i_Move_the_cursor_over_Women_s_link()  {
        purchase.moveToWomen();
    }

    @When("^I Click on the sub menu 'Dresses'\\.$")
    public void i_Click_on_the_sub_menu_Dresses()  {
        //Click on Action Move to Women tab
    }

    @When("^I Mouse hover on the last product displayed\\.$")
    public void i_Mouse_hover_on_the_last_product_displayed()  {
        //Moven and click in the next step.
    }

    @Given("^I click on 'More' button\\.$")
    public void i_click_on_More_button()  {
        purchase.selectLastProduct();
    }

    @Given("^I Increase quantity to \"([^\"]*)\"\\.$")
    public void i_Increase_quantity_to(String quantity)  {
        purchase.incrementQuantity(quantity);
    }

    @Given("^I Select size \"([^\"]*)\"$")
    public void i_Select_size(String size)  {
        purchase.selectSizeDropDown(size);
    }

    @Given("^I Select color.$")
    public void i_Select_color()  {
        purchase.selectColor();
    }

    @Given("^I Click the 'Add to Cart' button\\.$")
    public void i_Click_the_Add_to_Cart_button()  {
        purchase.clickAddCart();
    }

    @Given("^I Click the 'Proceed to checkout' button\\.$")
    public void i_Click_the_Proceed_to_checkout_button()  {
        purchase.checkoutProceed();
    }

    @Given("^I Complete the buy order process till payment\\.$")
    public void i_Complete_the_buy_order_process_till_payment()  {
        purchase.proceedToPayment();
    }

    @Then("^I Make sure that Product is ordered\\.$")
    public void i_Make_sure_that_Product_is_ordered()  {
        String confirmationMsg = "Your order on My Store is complete.";
       String actualConfirmationMsg =  purchase.validation();
        Assert.assertEquals(confirmationMsg,actualConfirmationMsg);
    }
}
