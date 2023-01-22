package com.banking.testCases;

import com.banking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass{


    @Test
    public void loginTest() throws InterruptedException {
        driver.get(baseURL);

        logger.info("URL is opened");
        LoginPage lp= new LoginPage(driver);
        Thread.sleep(1500);
        lp.acceptCookies();
        logger.info("Cookies accepted");
        lp.setUserName(username);
        logger.info("Entered username");
        lp.setPassword(password);
        logger.info("Entered password");
        Thread.sleep(1000);
        lp.clickSubmit();
        Assert.assertTrue(driver.getTitle().equals("Guru99 Bank Manager HomePage"));

    }


}
