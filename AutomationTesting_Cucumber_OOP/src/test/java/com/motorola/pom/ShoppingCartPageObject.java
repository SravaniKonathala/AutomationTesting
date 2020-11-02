package com.motorola.pom;

import com.motorola.utils.Constants;
import com.motorola.utils.DriverInitialization;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPageObject extends DriverInitialization {

    @FindBy(xpath = Constants.SECOND_ELEMENT_XPATH)
    WebElement mouseHoverSecondElement;

    @FindBy(xpath = Constants.SECOND_ELE_MORE_BUTTON_XPATH)
    WebElement secondProductMoreButton;

    @FindBy(id = Constants.QUANTITY_ID)
    WebElement quantity;

    @FindBy(name = Constants.WHITE_COLOR_NAME)
    WebElement color;

    @FindBy(id = Constants.PRODUCT_PRICE_ID)
    WebElement productPrice;

    @FindBy(id = Constants.UPDATE_QUANTITY_ID)
    WebElement updateQuantity;

    @FindBy(name = Constants.UPDATE_QUANTITY_VALUE_NAME)
    WebElement updatedQuantityValue;

    /**
     * @method  mouseHoverOnSecondElement()
     * @description  method mouse hover to second product in the list
     */

      public void mouseHoverOnSecondElement(){
        Actions actions = new Actions(driver);
        actions.moveToElement(mouseHoverSecondElement).perform();
    }

    public void clickOnSecondProductMoreButton(){
        secondProductMoreButton.click();
    }

    /**
     * @method readQuantity()
     * @description reads the attribute value of 'quantity' webElement
     * @return quantity.getAttribute("value")
     */

    public String readQuantity(){
        //System.out.println("quantity.getAttribute value: "+ quantity.getAttribute("value"));
        return quantity.getAttribute("value");
    }

    /**
     * @method selectColor()
     * @description selects the color code of the product
     */

    public void selectColor(){
        color.click();
    }

    /**
     * @method singleProductPrice()
     * @description extracts the price of the product, where the price includes the currency so from obtained
     * * text the price is taken as subString and converted to integer and value is returned
     * @return val1
     */
    public Integer singleProductPrice(){
        String singleProductValue = productPrice.getText();
        String value = singleProductValue.substring(1,3);
        int val1 = Integer.parseInt(value);
        //System.out.println("subString: "+value);
        return val1;
    }

    /**
     * @method changeProductQuantity()
     * @description clicks on '+' symbol by 1 time and updates the quantity of the product by 1 time
     */

    public void changeProductQuantity(){
        updateQuantity.click();
    }

    /**+
     * @method  validateTheUpdatedPrice()
     * @description  reads the updated price and returns the value
     * @return Integer.parseInt(updatedValue)
     */
    public int validateTheUpdatedPrice(){
        String valueOfUpdatedQuantity = productPrice.getText();
        String updatedValue = valueOfUpdatedQuantity.substring(1,3);
        //System.out.println("updatedValue: "+updatedValue);
        return Integer.parseInt(updatedValue);
    }


    /**
     * @method  getUpdatedQuantityValue()
     * @description gets the updated quantity value and returns quantity value
     * @return Integer.parseInt(qty)
     */
    public int getUpdatedQuantityValue(){
        String qty = updatedQuantityValue.getAttribute("value");
        return Integer.parseInt(qty);
    }
}
