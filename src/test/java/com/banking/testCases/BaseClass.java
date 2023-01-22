package com.banking.testCases;

import com.banking.utilities.ReadConfig;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.logging.Logger;

public class BaseClass {

    public WebDriver driver;
    public static Logger logger;

    ReadConfig readconfig = new ReadConfig();

    public String baseURL=readconfig.getApplicationURL();//This access is valid only for 20 days. starting 21/01/2023
    public String username=readconfig.getUsername();
    public String password=readconfig.getPassword();


    @Parameters("browser")
    @BeforeClass
    public void setup (String br){
        switch (br) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
        }
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    logger= Logger.getLogger("eBanking");
    System.setProperty("log4j.configurationFile","./path_to_the_log4j2_config_file/log4j2.xml");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}
