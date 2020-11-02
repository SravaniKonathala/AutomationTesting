package com.motorola.pom;

import com.motorola.utils.Constants;
import com.motorola.utils.DriverInitialization;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PurchaseProductPageObject extends DriverInitialization {

    @FindBy(name = Constants.LOGIN_EMAIL)
    WebElement loginEmail;

    @FindBy(name = Constants.PWD)
    WebElement pwd;

    @FindBy(xpath = Constants.SIGN_IN_BUTTON_XPATH)
    WebElement signInButton;

    @FindBy(xpath = Constants.SUBMIT_SIGNIN_XPATH)
    WebElement submitSignIn;

    @FindBy(className = Constants.LAST_ELEMENT_CLASSNAME)
    WebElement lastElement;

    @FindBy(xpath = Constants.MORE_BUTTON_XPATH)
    WebElement moreButton;

    @FindBy(id = Constants.QUANTITY_ID)
    WebElement quantity;

    @FindBy(xpath = Constants.SIZE_XPATH)
    WebElement size;

    @FindBy(name = Constants.GREEN_COLOR_NAME)
    WebElement greenColorCode;

    @FindBy(name = Constants.ADD_TO_CART_NAME)
    WebElement addToCart;

    @FindBy(xpath = Constants.CHECKOUT_XPATH)
    WebElement checkout;

    @FindBy(xpath = Constants.PROCEED_XPATH)
    WebElement proceed;

    @FindBy(name = Constants.PROCEED_ADDRESS_NAME)
    WebElement proceedAddress;

    @FindBy(name = Constants.PROCEED_CARRIER_NAME)
    WebElement proceedCarrier;

    @FindBy(name = Constants.T_A_C_NAME)
    WebElement termsAndConditions;

    @FindBy(xpath = Constants.PAY_BY_WIRE_XPATH)
    WebElement payByWire;

    @FindBy(xpath = Constants.CONFIRM_ORDER_BUTTON)
    WebElement confirmOrderButton;

    @FindBy(xpath = Constants.ORDER_CONFIRMATION_XPATH)
    WebElement orderConfirmation;

    @FindBy(xpath = Constants.DRESSES_MENU_XPATH)
    WebElement dressesMenu;

    @FindBy(xpath = Constants.WOMAN_XPATH)
    WebElement women;

    /**
     * @method login()
     * @description initializes the WebElements and perform login with valid login details
     * @param username
     * @param password
     */

    public void login( String username, String password){
        explicitWait(signInButton, 10);
        signInButton.click();
        explicitWaitSendKeys(loginEmail, 10);
        loginEmail.sendKeys(username);
        pwd.sendKeys(password);
        submitSignIn.click();
    }

    /**
     * @method moveToWomen()
     * @description perform mouseover action using Actions class and clicks the WebElement.
     */
    public void moveToWomen(){
        Actions actions = new Actions(driver);
        women.click();
        actions.moveToElement(women).click(dressesMenu);
    }

    public void selectLastProduct() {
        Actions action = new Actions(driver);
        action.moveToElement(lastElement).click(moreButton).perform();
    }

    /**
     * @method incrementQuantity()
     * @description clears the quantity block and update the new quantity value in quantity block
     * @param quantityCount
     */

    public void incrementQuantity(String quantityCount){
        quantity.clear();
        quantity.sendKeys(quantityCount);
    }

    /**
     * @method selectSizeDropDown()
     * @description select the size of the product using Select class, where size is specified as parameter.
     * @param specSize
     */

    public void selectSizeDropDown(String specSize){
        Select select = new Select(size);
        select.selectByVisibleText(specSize);
    }

    public void selectColor(){
        greenColorCode.click();
    }

    /**
     * @method clickAddCart()
     * @description click the product to add to cart and proceed to checkout
     */
    public void clickAddCart() {
        addToCart.click();
        explicitWait(proceed,5);
        proceed.click();
    }

    /**
     * @method checkoutProceed()
     * @description include the entire process of checkout till payment
     */
    public void checkoutProceed(){
        implicitWait();
        checkout.click();
        proceedAddress.click();
        termsAndConditions.click();
        proceedCarrier.click();
    }

    /**
     * @method proceedToPayment()
     * @description process of checkout from payment to order confirmation
     */

    public void proceedToPayment(){
        payByWire.click();
        explicitWait(confirmOrderButton,10);
        confirmOrderButton.click();
    }

    /**
     * @method validation()
     * @description validates the order confirmation msg
     * @return orderConfirmation.getText()
     */

    public String validation(){
        return orderConfirmation.getText();
    }
}
