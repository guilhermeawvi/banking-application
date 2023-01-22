import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class WebPages extends PageObject {
    private final String DOCUMENT_ID = "Y123456D";
    private final String FILE_PATH = System.getProperty("user.dir")+"//Screenshot//";

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath ="//div[@class='buttons']/a[1]/span")
    private WebElement newClient;


    public WebPages(WebDriver driver) {
        super(driver);
    }



    //Take screenshot
    public void takeScreenShot(String fileName)   {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(FILE_PATH+fileName+".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot path: "+destFile);
        } catch (Exception e) {
            e.getMessage();
        }
    }


}