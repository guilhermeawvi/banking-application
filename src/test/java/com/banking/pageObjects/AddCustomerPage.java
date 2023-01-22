package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;


public class AddCustomerPage extends PageObjects {

    public AddCustomerPage(WebDriver driver){
        super(driver);
    }

    @FindBy(how = How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
    @CacheLookup
    WebElement addNewCustomerLink;

    @FindBy(how = How.NAME, using = "name")
    @CacheLookup
    WebElement txtCustomerName;

    @FindBy(how = How.NAME, using = "rad1")
    @CacheLookup
    WebElement rdGender;

    @FindBy(how = How.ID_OR_NAME,using="dob")
    @CacheLookup
    WebElement txtDob;

    @FindBy(how = How.NAME,using ="addr")
    @CacheLookup
    WebElement txtAddress;

    @FindBy(how = How.NAME, using ="city")
    @CacheLookup
    WebElement txtCity;

    @FindBy(how = How.NAME,using="state")
    @CacheLookup
    WebElement txtState;

    @FindBy(how = How.NAME,using="pinno")
    @CacheLookup
    WebElement txtPinno;

    @FindBy(how = How.NAME,using="telephoneno")
    @CacheLookup
    WebElement txtPhone;

    @FindBy(how = How.NAME,using="emailid")
    @CacheLookup
    WebElement txtEmailId;

    @FindBy(how = How.NAME,using="password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(how = How.NAME,using="sub")
    @CacheLookup
    WebElement  submitBtn;



    public void clickAddNewCustomer(){addNewCustomerLink.click();}
    public void setName(String cName){txtCustomerName.sendKeys(cName);}
    public void setGender(String cGender){rdGender.click();}
    public void setDob(String mm, String dd, String yy){
        txtDob.sendKeys(mm);
        txtDob.sendKeys(dd);
        txtDob.sendKeys(yy);
    }
    public void setAddress(String cAddress){txtAddress.sendKeys(cAddress);}
    public void setCity(String cCity){txtCity.sendKeys(cCity);}
    public void setState(String cState){txtState.sendKeys(cState);}
    public void setPinno(String cPinno){txtPinno.sendKeys(String.valueOf(cPinno));}
    public void setPhone(String cPhone){txtPhone.sendKeys(cPhone);}
    public void setEmail(String cEmail){txtEmailId.sendKeys(cEmail);}
    public void setPassword(String cPassword){txtPassword.sendKeys(cPassword);}
    public void cSubmit(){submitBtn.click();}


}
