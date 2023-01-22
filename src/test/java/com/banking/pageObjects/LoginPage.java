package com.banking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class LoginPage extends PageObjects {

    //public WebDriver driver;


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(id="gdpr-consent-notice")
    WebElement iframe;
    @FindBy(xpath="//span[normalize-space()='Accept All']")
    private WebElement acceptCookies;
    @FindBy(name="uid")
    @CacheLookup
    private WebElement txtUserName;
    @FindBy(name="password")
    @CacheLookup
    WebElement txtPassword;
    @FindBy(name="btnLogin")
    @CacheLookup
    WebElement btnLogin;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void acceptCookies(){

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(this.iframe));
        wait.until(ExpectedConditions.elementToBeClickable(this.acceptCookies)).click();
        driver.switchTo().parentFrame();
    }
    public void setUserName(String uname)
    {
        System.out.println(this.txtUserName);
        this.txtUserName.sendKeys((uname));

    }
    public void setPassword(String upassword)
    {
        this.txtPassword.sendKeys((upassword));

    }
    public void clickSubmit(){
        this.btnLogin.click();
    }





}
