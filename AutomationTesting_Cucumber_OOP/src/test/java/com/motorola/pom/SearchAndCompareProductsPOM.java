package com.motorola.pom;

import com.motorola.utils.Constants;
import com.motorola.utils.DriverInitialization;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchAndCompareProductsPOM extends DriverInitialization {
        @FindBy(name = Constants.SEARCH_BOX_NAME)
        WebElement searchBox;

        @FindBy(xpath = Constants.WOMAN_TAB_XPATH)
        WebElement womanTab;

        @FindBy(xpath = Constants.SUMMER_DRESS_XPATH)
        WebElement summerDresses;

        @FindBy(className = Constants.LAST_ELEMENT_CLASSNAME)
        public WebElement lastElement;

        @FindBy(name = Constants.SUBMIT_SEARCH_NAME)
        WebElement searchButton;

        @FindBy(xpath = Constants.LAST_ITEM_TITLE_XPATH)
        WebElement lastItemTitle;

    /**@method  Name: openTheLink()
     * @description initialize the webElements and launch the application
     * @param url
     */

public void openTheLink(String url){
        driver.get(url);
}

    /**
     * @method moveTheCursor()
     * @description perform mouse hover action using Actions class and click on woman dresses link
     */

 public void moveTheCursor(){
        explicitWait(womanTab, 10);
        Actions actions = new Actions(driver);
        womanTab.click();
        actions.moveToElement(womanTab).click(summerDresses);
 }

    /**
     * @method getLastElement()
     * @description wait for the element to load and get the description od the product and return the text
     * @return lastElement.getText()
     */
 public String getLastElement(){
     //System.out.println("lastElement in Last: "+lastElement.getText());
     implicitWait();
     return lastElement.getText();
 }

    /**
     * @method searchInSearchBox()
     * @description gets the last product details and search for the same product in search box on top of page
     * and return the details of the same product
     * @return lastElement.getText()
     */
 public String searchInSearchBox(){
        String lastProduct = lastItemTitle.getText();
      //   System.out.println("lastProduct: "+lastProduct);
        searchBox.sendKeys(lastProduct);
        searchButton.click();
     // System.out.println("lastElement.getText: "+lastElement.getText());
         return lastElement.getText();
 }
}

