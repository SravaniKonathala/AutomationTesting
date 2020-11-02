package com.motorola.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverInitialization {
    public static WebDriver driver;

    /**
     * @method initializeDriver(String driverType)
     * @description take the drivertype parameters and initialize the driver
     * @param driverType
     */
    public void initializeDriver(String driverType){
        if(driverType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(driverType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(driverType.equalsIgnoreCase("ie")){
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
    }

    /**
     * @constructor  DriverInitialization()
     * @description Initialize the webElement
     */
    public DriverInitialization(){
        PageFactory.initElements(driver,this);
    }

    /**
     * @method implicitWait()
     * @description selenium implicit wait
     */
    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    /**
     * @method explicitWait(WebElement webElement, long time)
     * @description selenium explicit wait using WebDriverWait to perform click action
     * @param webElement webelement to be searched
     * @param time max time to wait
     */
    public void explicitWait(WebElement webElement, long time){
        WebDriverWait driverWait = new WebDriverWait(driver,time);
        driverWait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * @method explicitWaitSendKeys(WebElement webElement, long time)
     * @description selenium explicit wait using WebDriverWait to perform sendKeys action
     * @param webElement webelement to be searched
     * @param time max time to wait
     */
    public void explicitWaitSendKeys(WebElement webElement, long time){
        WebDriverWait driverWait = new WebDriverWait(driver,time);
        driverWait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(webElement));
    }

}
