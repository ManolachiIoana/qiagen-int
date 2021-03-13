package config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.text.SimpleDateFormat;
import java.util.Date;

import static utils.UrlVariables.APP_NAME;
import static utils.UrlVariables.BASE_URL;


public abstract class AbstractAcceptanceTest {

    private static WebDriver driver;

    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent = new ExtentReports();
    public ExtentTest test;

    protected static WebDriver getWebDriver() {
        return driver;
    }

    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();

        htmlReporter = new ExtentHtmlReporter("target/Report_" + APP_NAME + "_" + new SimpleDateFormat("yyyy_MM_dd").format(new Date()) + ".html");
        htmlReporter.setAppendExisting(true);
        extent.attachReporter(htmlReporter);
    }

    @BeforeMethod
    public void openApplication() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void destroy(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test failed " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test skipped " + result.getThrowable());
        } else {
            test.log(Status.PASS, "Test passed");
        }
        extent.flush();
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}

