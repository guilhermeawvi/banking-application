package com.banking.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class PageObjects {
    protected WebDriver driver;

    public PageObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
