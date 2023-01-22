package com.banking.utilities;

//Listener Class used to generate extent reports

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter {

    public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    public void onStart(ITestContext testContext) {

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//Time stamp
        String repName = "Teste-Report-" + timeStamp + ".html";

        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repName);//Specify location
        try {
            htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "Guilherme");

        htmlReporter.config().setDocumentTitle("Banking Application Test Project");//Title of report
        htmlReporter.config().setReportName("Functional Test Report");//Name of the report

        htmlReporter.config().setTheme(Theme.DARK);
    }
        public void onTestSuccess(ITestResult tr){
            logger=extent.createTest(tr.getName());//create new entry in the report
            logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));//Send the passed information

        }
        public void onTestFailure(ITestResult tr){
            logger=extent.createTest(tr.getName());//create new entry in the report
            logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));//Send the passed information
            String screenShotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";

            File f= new File(screenShotPath);
            if(f.exists()){
                logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(screenShotPath));
            }
        }
        public void onTestSkipped(ITestResult tr){
            logger=extent.createTest(tr.getName());//create new entry in the report
            logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));//Send the passed information
}
        public void onFinish(ITestContext testContext){
            extent.flush();
}



    }




