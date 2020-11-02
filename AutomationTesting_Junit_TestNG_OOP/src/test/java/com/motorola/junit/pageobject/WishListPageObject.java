package com.motorola.junit.pageobject;

import com.motorola.junit.utils.Constants;
import com.motorola.junit.utils.DriverInitialization;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPageObject extends DriverInitialization {

    @FindBy(xpath = Constants.SIGN_IN_BUTTON_XPATH)
    WebElement singInButton;

    @FindBy(xpath = Constants.FIRST_PRODUCT_XPATH)
    WebElement firstProduct;

    @FindBy(xpath = Constants.FP_WISHLIST_XPATH)
    WebElement addWishListButton;

    @FindBy(xpath = Constants.CANCEL_MSG_XPATH)
    WebElement errorMsgClose;

    @FindBy(xpath = Constants.ERROR_MSG_TEXT_XPATH)
    WebElement errorMsgText;

    @FindBy(xpath = Constants.SECOND_ELEMENT_XPATH)
    WebElement secondElement;

    @FindBy(xpath = Constants.SECOND_ELEMENT_WISHLIST_XPATH)
    WebElement secondProductAddWishList;

    @FindBy(xpath = Constants.CANCEL_MSG_XPATH)
    WebElement cancelMsg;

    @FindBy(xpath = Constants.USERNAME_XPATH)
    WebElement userName;

    @FindBy(xpath = Constants.WISH_LIST_MY_ACCOUNT_XPATH)
    WebElement wishlistInMyAccount;

    @FindBy(xpath = Constants.DRESSES_MENU_XPATH)
    WebElement dressesMenu;

    @FindBy(xpath = Constants.WOMAN_XPATH)
    WebElement women;



    /**
     * @method isSignInButtonPresent()
     * @description validates whether the signIn button is enabled or not
     * @return isSignInButtonEnabled
     */
    public boolean isSignInButtonPresent(){
        PageFactory.initElements(driver,this);
        boolean isSignInButtonEnabled = false;
        if (singInButton.isEnabled()) {
            isSignInButtonEnabled = true;
        }
        return isSignInButtonEnabled;
    }

    /**
     * @method mouseOverToFirstProduct()
     * @description perform mouse hover action on first product of the list
     */
    public void mouseOverToFirstProduct(){
        implicitWait();
        Actions actions = new Actions(driver);
        actions.moveToElement(firstProduct).perform();
    }

    /**
     * @method clickOnWishList()
     * @description click on the wish list button of the first product
     */
    public void clickOnWishList() {
        implicitWait();
       // explicitWait(addWishListButton , 10);
        addWishListButton.click();
    }

    /**
     * @method handelSignInAlert()
     * @description wait for the error message and reads the error message and returns it
     * @return errorText
     */
    public String handelSignInAlert() {
        implicitWait();
        String errorText = errorMsgText.getText();
        System.out.println("errorText: "+errorText);
        errorMsgClose.click();
        return errorText;
    }

    /**
     * @method clickOnSecondProduct()
     * @description move the mouse to the second element in the list and click on the add WishList
     */
    public void clickOnSecondProduct(){
        //implicitWait();
        Actions actions = new Actions(driver);
        actions.moveToElement(secondElement).perform();
        secondProductAddWishList.click();
    }

    public void hoverToWomen(){
        Actions actions = new Actions(driver);
        women.click();
        actions.moveToElement(women).click(dressesMenu);
    }


    /**
     * @method addWishListSuccessMsg()
     * @description close the error msg and verfies whether the product is added to wishlist or not in MyAccount
     */
    public void addWishListSuccessMsg()  {
        explicitWait(cancelMsg,5);
      //String actualMsg =  addWishListSuccessMsg.getText();
        cancelMsg.click();
        explicitWait(userName, 10);
        userName.click();
        wishlistInMyAccount.click();
      //  String productDetails = productDetailsInWishList.getText();
     //   System.out.println("productDetails: "+productDetails);
    }
}
