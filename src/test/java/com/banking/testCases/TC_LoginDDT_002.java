package com.banking.testCases;

import com.banking.pageObjects.LoginPage;
import com.banking.utilities.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass{

    @Test(dataProvider = "LoginData")
    public void loginDDT(String user, String pwd) throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(user);
        logger.info("User name provided");
        lp.setPassword(pwd);
        logger.info("Password provided");
        lp.clickSubmit();

        Thread.sleep(3000);

        if(isAlertPresent()){
            driver.switchTo().alert().accept();//close the alert
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.warning("Login failed");
        }else{
            Assert.assertTrue(true);
            logger.info("Login passed");
            lp.clickLogOut();
            Thread.sleep(3000);
            driver.switchTo().alert().accept();//close logout alert
            driver.switchTo().defaultContent();
        }
    }

    @DataProvider(name="LoginData")
    String[][] getData() throws IOException {
    String path=System.getProperty("user.dir")+"/src/test/java/com/banking/testData/LoginData.xlsx";
    String ws = "Sheet1";
    int rowCount = XLUtils.getRowCount(path,ws);
    int colCount=XLUtils.getCellCount(path,ws,1);

    String loginData[][]=new String [rowCount][colCount];

    for(int i=1;i<=rowCount;i++){
        for(int j=0;j<colCount;j++){
            loginData[i-1][j]=XLUtils.getCellData(path,ws,i,j);
        }
    }
    return loginData;
    }
}
