package com.motorola.stepdefinition;

import com.motorola.pom.UserRegisPageObject;
import com.motorola.utils.CommonUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.Properties;

public class UserRegistrationStepDef {
    UserRegisPageObject userRegisPageObject = new UserRegisPageObject();
    CommonUtils commonUtils = new CommonUtils();
    Properties properties;
    @Given("^I launch the browser \"([^\"]*)\"$")
    public void i_launch_the_browser(String browserType)  {
        userRegisPageObject.launchBrowser(browserType);
    }

    @Given("^I Open this URL {2}\"([^\"]*)\"$")
    public void i_Open_this_URL(String url)  {
        userRegisPageObject.openApplication(url);
    }

    @When("^I Click on the 'Sign in' button\\.$")
    public void i_Click_on_the_Sign_in_button()  {
        userRegisPageObject.clickOnSignIn();
    }

    @When("^I Enter email address in the 'CREATE AN ACCOUNT' section for \"([^\"]*)\"\\.$")
    public void i_Enter_email_address_in_the_CREATE_AN_ACCOUNT_section_for(String username)  {
            userRegisPageObject.enterEmail(username);
    }

    @When("^I Click on Create an Account button\\.$")
    public void i_Click_on_Create_an_Account_button()  {
        userRegisPageObject.clickOnCreateAccount();
    }

    @When("^I Enter Personal Information, Address, and Contact info for \"([^\"]*)\"\\.$")
    public void i_Enter_Personal_Information_Address_and_Contact_info_for(String userName)  {
        userRegisPageObject.enterUserInformation(userName);
    }


    @When("^I Click on the Register button\\.$")
    public void click_on_the_Register_button()  {
        userRegisPageObject.clickOnRegistration();
    }

    @Then("^I Validate that the user is created\\.$")
    public void validate_that_the_user_is_created()  {
        boolean value = userRegisPageObject.validateRegistration();
        Assert.assertTrue(value);
       // System.out.println("User Registered Successfully");
    }


    @When("^I Enter invalid \"([^\"]*)\" address in the email box and click enter\\.$")
    public void enter_invalid_address_in_the_email_box_and_click_enter(String invalidEmail)  {
        userRegisPageObject.enterLoginInvalidEmail(invalidEmail);
    }

    @Then("^I Validate that an error message is displaying saying \"([^\"]*)\"$")
    public void validate_that_an_error_message_is_displaying_saying(String expectedErrorMsg) {
        String actualMsg = userRegisPageObject.validateLogin();
        Assert.assertEquals(expectedErrorMsg,actualMsg );
    }

    @When("^I Enter a valid \"([^\"]*)\" address and click on Create an Account button\\.$")
    public void enter_a_valid_address_and_click_on_Create_an_Account_button(String validEmail) {
        userRegisPageObject.giveEmail(validEmail);
        userRegisPageObject.clickOnCreateAccount();
    }

    @When("^I Leave the mandatory fields \\(marked with \\*\\) blank and click the Register button\\.$")
    public void leave_the_mandatory_fields_marked_with_blank_and_click_the_Register_button() {
        userRegisPageObject.submitRegistration();
    }

    @Then("^I Verify that \"([^\"]*)\" has been displayed only for the mandatory fields\\.$")
    public void verify_that_has_been_displayed_only_for_the_mandatory_fields(String actualErrorMsg) {
       String expectedErrorMsg =  userRegisPageObject.validateRegistrationErrorMsg();
       Assert.assertEquals(actualErrorMsg ,expectedErrorMsg );
    }

    @When("^I Enter incorrect values in fields like enter numbers in first name \"([^\"]*)\" and last name \"([^\"]*)\", alphabets in Mobile no \"([^\"]*)\", invalid Zip postal code \"([^\"]*)\" , \"([^\"]*)\", \"([^\"]*)\"and click on the 'Register' button\\.$")
    public void enter_incorrect_values_in_fields_like_enter_numbers_in_first_name_and_last_name_alphabets_in_Mobile_no_invalid_Zip_postal_code_and_click_on_the_Register_button(String firstName, String lastName, String mobileNo, String zipcode, String address, String city)  {
      // Thread.sleep(3000);
        userRegisPageObject.fillRegistrationWithInvalidData(firstName,lastName, mobileNo,zipcode, address, city );
    }

    @Then("^I Verify that error messages for respective fields are displaying\\.$")
    public void verify_that_error_messages_for_respective_fields_are_displaying()  {
        try {
            String actualMsg = userRegisPageObject.validateErrorMsg();
            properties = commonUtils.readErrorMsgFile();
            String msg = (String) properties.get("unsuccessfulRegistrationMessage");
           // System.out.println("msg: "+msg);
            Assert.assertEquals(msg , actualMsg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Then("^I quit the browser\\.$")
    public void i_Quit_the_browser()  {
        userRegisPageObject.quitBrowser();
    }
    

}
