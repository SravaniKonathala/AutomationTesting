package com.motorola.stepdefinition;

import com.motorola.pom.SearchAndCompareProductsPOM;
import com.motorola.utils.DriverInitialization;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ProductSearchStepDef {
    SearchAndCompareProductsPOM searchAndCompareProductsPOM = new SearchAndCompareProductsPOM();
    String lastElementText, searchElementFound;
    DriverInitialization driverInitialization;
    @Given("^I Open link \"([^\"]*)\"$")
    public void i_Open_link(String url)  {
        searchAndCompareProductsPOM.openTheLink(url);
    }

    @When("^I Move your cursor over Women's link\\.$")
    public void i_Move_your_cursor_over_Women_s_link() throws InterruptedException {
        searchAndCompareProductsPOM.moveTheCursor();
    }

    @When("^I Click on sub menu 'Summer Dresses'$")
    public void i_Click_on_sub_menu_Summer_Dresses()  {
        //Action performed when mouse action is performed
    }

    @When("^I Get Name/Text of the last product displayed on the page\\.$")
    public void i_Get_Name_Text_of_the_last_product_displayed_on_the_page()  {
        lastElementText = searchAndCompareProductsPOM.getLastElement();
    }

    @When("^I Now enter the same product name in the search bar present on top of page and click the search button\\.$")
    public void i_Now_enter_the_same_product_name_in_the_search_bar_present_on_top_of_page_and_click_the_search_button()  {

        searchElementFound = searchAndCompareProductsPOM.searchInSearchBox();
    }

    @Then("^I Validate that the same product is displayed on a searched page with the same details which were displayed on T-Shirt's page\\.$")
    public void i_Validate_that_the_same_product_is_displayed_on_a_searched_page_with_the_same_details_which_were_displayed_on_T_Shirt_s_page()  {
        Assert.assertEquals(lastElementText,searchElementFound);
    }


}
