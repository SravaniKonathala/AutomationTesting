package com.motorola.junit.pageobject;

import com.motorola.junit.utils.*;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;

public class UserRegisPageObject extends DriverInitialization {
    ReadUserJsonFile readUserJsonFile= new ReadUserJsonFile();
    UserDetailsBean userDetailsBean;

    @FindBy(xpath = Constants.SIGN_IN_BUTTON_XPATH)
    WebElement signInButton;

    @FindBy(name = RegistrationConstants.CREATE_ACCOUNT_EMAIL_NAME)
    WebElement createAccountEmail;

    @FindBy(xpath = RegistrationConstants.CREATE_ACCOUNT_XPATH)
    WebElement createAccount;

    @FindBy(xpath = RegistrationConstants.TITLE_XPATH)
    WebElement fGender;

    @FindBy(name = RegistrationConstants.FIRSTNAME_NAME)
    WebElement firstName;

    @FindBy(name = RegistrationConstants.LASTNAME_NAME)
    WebElement lastName;

    @FindBy(xpath = RegistrationConstants.DAYS_XPATH)
    WebElement days;

    @FindBy(xpath = RegistrationConstants.MONTH_XPATH)
    WebElement month;

    @FindBy(xpath = RegistrationConstants.YEAR_XPATH)
    WebElement year;

    @FindBy(name = Constants.PWD)
    WebElement pwd;


    @FindBy(name = RegistrationConstants.COMPANY_NAME)
    WebElement company;

    @FindBy(name = RegistrationConstants.ADDRESS_NAME)
    WebElement address;

    @FindBy(name = RegistrationConstants.CITY_NAME)
    WebElement city;

    @FindBy(xpath = RegistrationConstants.STATE_XPATH)
    WebElement state;

    @FindBy(name = RegistrationConstants.POSTCODE_NAME)
    WebElement postalCode;

    @FindBy(name = RegistrationConstants.MOBILE_NUM_NAME)
    WebElement mobileNumber;

    @FindBy(name = RegistrationConstants.ALIAS_ADDRESS_NAME)
    WebElement aliasAddress;

    @FindBy(xpath = RegistrationConstants.REGISTER_BUTTON_XPATH)
    WebElement registerButton;

    @FindBy(name = Constants.LOGIN_EMAIL)
    WebElement loginEmail;

    @FindBy(xpath = RegistrationConstants.INVALID_EMAIL_ERROR_MSG)
    WebElement errorMsg;

    @FindBy(xpath = RegistrationConstants.SIGN_OUT_XPATH)
    WebElement signOut;

    @FindBy(xpath = RegistrationConstants.REGISTRATION_ERROR_XPATH)
    WebElement registrationError;

    @FindBy(xpath = RegistrationConstants.REGIS_ERROR_MSG_XPATH)
    WebElement errorMessage;

    public void launchBrowser(String browserType){
        initializeDriver(browserType);
    }

    /**
     * @method openApplication(String url)
     * @description launch the apllication and initialize the webElement
     * @param url
     */
    public void openApplication(String url){
        PageFactory.initElements(driver,this);
        driver.get(url);
    }
    public void clickOnSignIn(){
        signInButton.click();
    }

    /**
     * @method enterEmail(String userName)
     * @description read json file and retrieve the email of the userName
     * @param userName username in json file
     */
    public void enterEmail(String userName){
        try {
            userDetailsBean = readUserJsonFile.readUserJSON(userName);
            explicitWaitSendKeys(createAccountEmail, 10);
            createAccountEmail.sendKeys(userDetailsBean.getEmail());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void clickOnCreateAccount(){
        createAccount.click();
    }

    /**
     * @method enterUserInformation(String userName)
     * @description username is passed as parameter, username is passed to json file to retrieve the user details and
     * fill the form
     * @param userName user in json file
     */
    public void enterUserInformation(String userName){
        try {
            userDetailsBean = readUserJsonFile.readUserJSON(userName);
            explicitWait(fGender, 10);
            fGender.click();
            firstName.sendKeys(userDetailsBean.getFirstName());
            lastName.sendKeys(userDetailsBean.getLastName());
            pwd.sendKeys(userDetailsBean.getPassword());
            Select selectDay = new Select(days);
            selectDay.selectByValue("18");
            Select selectMonth = new Select(month);
            selectMonth.selectByValue("11");
            Select selectYear = new Select(year);
            selectYear.selectByValue("1989");
            company.sendKeys(userDetailsBean.getCompanyName());
            address.sendKeys(userDetailsBean.getAddress());
            city.sendKeys(userDetailsBean.getCity());
            Select select = new Select(state);
            select.selectByVisibleText(userDetailsBean.getState());
            postalCode.sendKeys(userDetailsBean.getPostcode());
            //System.out.println("country: "+country.getText());
//            Select selectCountry = new Select(country);
//            selectCountry.selectByValue(userDetailsBean.getCountry());
            mobileNumber.sendKeys(userDetailsBean.getMobile());
            aliasAddress.clear();
            aliasAddress.sendKeys(userDetailsBean.getAliasAddress());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void clickOnRegistration(){
        explicitWait(registerButton , 10);
     //  registerButton.click();
    }

    public void submitRegistration(){
        explicitWait(registerButton , 10);
        registerButton.click();
    }

    public boolean validateRegistration(){
        return signOut.isEnabled();
    }

    /**
     * @method enterLoginInvalidEmail(String invalidEmail)
     * @description sends the invalid emails id and press enter is Keys class
     * @param invalidEmail
     */
    public void enterLoginInvalidEmail(String invalidEmail) {
        explicitWaitSendKeys(loginEmail , 10);
        loginEmail.sendKeys(invalidEmail);
        loginEmail.sendKeys(Keys.ENTER);
    }

    public String validateLogin(){
        return errorMsg.getText();
    }

    public void giveEmail(String validEmail){
        explicitWaitSendKeys(createAccountEmail, 5);
        createAccountEmail.sendKeys(validEmail);
    }

    /**
     * @method validateRegistrationErrorMsg()
     * @description gets the error msg text and returns it for validation
     * @return regErrorMsg
     */
    public String validateRegistrationErrorMsg(){
        implicitWait();
        String regErrorMsg = registrationError.getText();
       // System.out.println("Error Msg: "+registrationError.getText());
        return regErrorMsg;
    }

    /**
     * @method fillRegistrationWithInvalidData(String fN, String lN,String mobileNo, String zipcode ,String addr, String cityName)
     * @description fill the registration form with all details using the parameters
     * @param fN fullname
     * @param lN lastname
     * @param mobileNo mobile number
     * @param zipcode zipcode/pincode
     * @param addr address
     * @param cityName cityname
     */
    public void fillRegistrationWithInvalidData(String fN, String lN,String mobileNo, String zipcode ,String addr, String cityName){
            //explicitWaitSendKeys(firstName, 10);
        implicitWait();
            firstName.sendKeys(fN);
            lastName.sendKeys(lN);
            address.sendKeys(addr);
            city.sendKeys(cityName);
            postalCode.sendKeys(zipcode);
            mobileNumber.sendKeys(mobileNo);
            clickOnRegistration();
    }

    /**
     * @method validateErrorMsg()
     * @description retrieve the error message description
     * @return errorMessage text
     */
     public String validateErrorMsg()  {
         // System.out.println("Actual Msg: "+actualMsg);
        return errorMessage.getText();
     }

    /**
     * @method quitBrowser()
     * @description quits the launched browser
     */
    public void quitBrowser(){
        driver.quit();
    }
}
