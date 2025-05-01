package CoinHubModule.base;

import com.base.BasePage;
import com.driver.DriverManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.report.Reports;
import com.utils.PropertyReaderOptimized;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class TestBase {
    private Reports report;
    protected WebDriver driver;
    protected ExtentReports reports;
    protected ExtentTest test;
    private DriverManager driverManager;
    private BasePage basePage;

    // Constructor
    public TestBase() {
        initializeDriver();
        initializeBasePage();
        initializeReports();
    }

    // Initialization methods
    private void initializeDriver() {
        driverManager = new DriverManager();
        driver = driverManager.initializeChromeBrowser();
    }

    private void initializeBasePage() {
        basePage = new BasePage(driver);
    }

    private void initializeReports() {
        reports = Reports.getReportObject();
    }

    @BeforeClass
    public void beforeClassConfig() throws IOException {
        // Configure the browser window and navigate to the URL
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(700,700));
        String url = PropertyReaderOptimized.getKeyValue("stageUrl");
        basePage.navigateTo(url);
    }

    @AfterClass
    public void afterClassConfig() throws InterruptedException {
        // Perform cleanup activities
        Thread.sleep(2000); // Add explicit wait to ensure all tasks are completed
        if (reports != null && test != null) {
            reports.endTest(test);
            reports.flush();
        }
        if (driver != null) {
            driver.quit();
        }
    }
}