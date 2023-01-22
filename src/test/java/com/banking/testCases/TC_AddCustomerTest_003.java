package com.banking.testCases;

import com.banking.pageObjects.AddCustomerPage;
import com.banking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddCustomerTest_003 extends BaseClass{

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {
        LoginPage lp=new LoginPage(driver);
        Thread.sleep(1500);
        lp.acceptCookies();
        lp.setUserName(username);
        logger.info("User name provided");
        lp.setPassword(password);
        logger.info("Password provided");
        lp.clickSubmit();
        Thread.sleep(3000);

        String genEmail=randomAlphabeticString(6)+"@gmail.com";
        String genPassword=randomNumericString(6);
        String genPhone=randomNumericString(9);
        String genPinno=randomNumericString(6);

        AddCustomerPage addCust = new AddCustomerPage(driver);
        logger.info("Providing customer details...");
        addCust.clickAddNewCustomer();
        addCust.setName("Guilherme");
        addCust.setGender("male");
        addCust.setDob("10","12","1985");
        Thread.sleep(3000);
        addCust.setAddress("Spain");
        addCust.setCity("Zaragoza");
        addCust.setState("AR");
        addCust.setPinno(genPinno);
        addCust.setPhone(genPhone);
        addCust.setEmail(genEmail); //needs to be unique every iteration
        addCust.setPassword(genPassword);
        Thread.sleep(5000);
        addCust.cSubmit();
        Thread.sleep(3000);

        logger.info("Validation started...");

        boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
        if(res){
            Assert.assertTrue(true);
            logger.info("Test case passed");
        }else{
            logger.info("Test case failed");
            captureScreen(driver,"addNewCustomer");
            Assert.assertTrue(false);

        }
    }




}
