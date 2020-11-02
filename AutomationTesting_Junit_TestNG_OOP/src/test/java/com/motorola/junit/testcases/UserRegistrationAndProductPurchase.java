package com.motorola.junit.testcases;

import com.motorola.junit.pageobject.*;
import com.motorola.junit.utils.CommonUtils;
import com.motorola.junit.utils.DriverInitialization;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;


public class UserRegistrationAndProductPurchase extends DriverInitialization {
    UserRegisPageObject userRegisPageObject = new UserRegisPageObject();
    CommonUtils commonUtils = new CommonUtils();
    SearchAndCompareProductsPOM searchAndCompareProductsPOM = new SearchAndCompareProductsPOM();
    PurchaseProductPageObject purchaseProductPageObject = new PurchaseProductPageObject();
    WishListPageObject wishListPageObject = new WishListPageObject();
    ShoppingCartPageObject shoppingCartPageObject = new ShoppingCartPageObject();

    @BeforeMethod
    @Parameters({"driverType","url"})
    public void launchBrowserAndApplication(String driverType, String url){
        userRegisPageObject.launchBrowser(driverType);
        userRegisPageObject.openApplication(url);
    }

    /*
    * Create a new user with valid user details.
    * User details are retrieved from Json File
    * */
    @Test(priority = 1)
    @Parameters({"validEmail","userName"})
    public void registerNewUser( String validEmail,String userName){
        userRegisPageObject.clickOnSignIn();
        userRegisPageObject.giveEmail(validEmail);
        userRegisPageObject.clickOnCreateAccount();
        userRegisPageObject.enterUserInformation(userName);
       // userRegisPageObject.clickOnRegistration();
    }

    /*
    * Validate the error message on invalid email to create an account
    * */
    @Test(priority = 2)
    public void errorValidationOnInvalidEmailRegistration(){
        userRegisPageObject.clickOnSignIn();
        userRegisPageObject.enterLoginInvalidEmail("abc");
        String invalidEmailErrorMsg = userRegisPageObject.validateErrorMsg();
        String expectedErrorMsg = "There is 1 error\n" + "Invalid email address.";
        Assert.assertEquals(invalidEmailErrorMsg,expectedErrorMsg);
    }

    /*
    * Missing all the feilds in Registration and Submit the form.
    * Validate the error Message
    * */
    @Test(priority = 3)
    @Parameters({"validEmail"})
    public void validateErrorMsgForMandatoryFields(String validEmail) throws IOException {
        userRegisPageObject.clickOnSignIn();
        userRegisPageObject.giveEmail(validEmail);
        userRegisPageObject.clickOnCreateAccount();
        userRegisPageObject.submitRegistration();
       String actualErrorMsg =  userRegisPageObject.validateRegistrationErrorMsg();
        Properties properties =  commonUtils.readErrorMsgFile();
       String expectedErrorMsg = (String) properties.get("mandatoryFieldsErrorMsg");
       Assert.assertEquals(actualErrorMsg,expectedErrorMsg);
    }

    @Test(priority = 4)
    @Parameters({"validEmail"})
    public void verifyErrorMsgForIncorrectValues(String validEmail) throws IOException {
        userRegisPageObject.clickOnSignIn();
        userRegisPageObject.giveEmail(validEmail);
        userRegisPageObject.clickOnCreateAccount();
        userRegisPageObject.fillRegistrationWithInvalidData("aaaa","drgft","asdfghj","ig11nl","home","3456");
        userRegisPageObject.submitRegistration();
        String actualErrorMsg = userRegisPageObject.validateErrorMsg();
        Properties properties =  commonUtils.readErrorMsgFile();
        String expectedErrorMsg = (String) properties.get("unsuccessfulRegistrationMessage");
        Assert.assertEquals(actualErrorMsg,expectedErrorMsg);
    }

    @Test(priority = 5)
    public void automateSearchProductFunctionality(){
        searchAndCompareProductsPOM.moveTheCursor();
        String lastProduct = searchAndCompareProductsPOM.getLastElement();
        String lastProductInSearch = searchAndCompareProductsPOM.searchInSearchBox();
        Assert.assertEquals(lastProduct,lastProductInSearch);
    }

    @Test(priority = 6)
    @Parameters({"loginEmail","password","quantityCount","size"})
    public void automateBuyProduct(String loginEmail, String password,String quantityCount,String size){
        purchaseProductPageObject.login(loginEmail,password);
        purchaseProductPageObject.moveToWomen();
        purchaseProductPageObject.selectLastProduct();
        purchaseProductPageObject.incrementQuantity(quantityCount);
        purchaseProductPageObject.selectSizeDropDown(size);
        purchaseProductPageObject.selectColor();
        purchaseProductPageObject.clickAddCart();
        purchaseProductPageObject.checkoutProceed();
        purchaseProductPageObject.proceedToPayment();
        String actualSuccessMsg = purchaseProductPageObject.validation();
        System.out.println("ActualSuccessMsg: "+actualSuccessMsg);
    }

    @Test(priority = 7)
    public void wishListWorksAfterLogin(){
        wishListPageObject.isSignInButtonPresent();
        wishListPageObject.hoverToWomen();
        wishListPageObject.clickOnSecondProduct();
       String signError =  wishListPageObject.handelSignInAlert();
        System.out.println("SignIn Error Msg: "+signError);
    }

    @Test(priority = 8)
    @Parameters({"loginEmail","password"})
    public void addProductToWishListWithSignIn(String loginEmail, String password){
        wishListPageObject.isSignInButtonPresent();
        purchaseProductPageObject.login(loginEmail,password);
        wishListPageObject.hoverToWomen();
        wishListPageObject.clickOnSecondProduct();
        wishListPageObject.addWishListSuccessMsg();
    }

    @Test(priority = 9)
    @Parameters({"loginEmail","password"})
    public void verifyTotalPriceOnQuantityUpdate(String loginEmail, String password){
        wishListPageObject.isSignInButtonPresent();
        purchaseProductPageObject.login(loginEmail,password);
        wishListPageObject.hoverToWomen();
        shoppingCartPageObject.mouseHoverOnSecondElement();
        shoppingCartPageObject.clickOnSecondProductMoreButton();
        shoppingCartPageObject.readQuantity();
        purchaseProductPageObject.selectSizeDropDown("M");
        shoppingCartPageObject.selectColor();
        purchaseProductPageObject.clickAddCart();
        int singleProductPrice = shoppingCartPageObject.singleProductPrice();
        shoppingCartPageObject.changeProductQuantity();
        int updatedProductPrice = shoppingCartPageObject.validateTheUpdatedPrice();
        int updatedQuantityValue = shoppingCartPageObject.getUpdatedQuantityValue();
        int updatePrice = updatedQuantityValue*singleProductPrice;
        Assert.assertEquals(updatedProductPrice,updatePrice );
    }
    @AfterMethod
    public void tearDown(){
        exitBrowser();
    }
}
