package CoinHubModule.tests.web;

import CoinHubModule.base.TestBase;
import com.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import com.report.Reports;
import com.utils.PropertyReaderOptimized;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class HomePageScript extends TestBase {
    HomePage homePage;
    SoftAssert softAssert;

    public HomePageScript() throws InterruptedException {
        homePage=new HomePage(driver);
        softAssert=new SoftAssert();
    }

    @Test(priority = 1)
    public void verifyIsTitlePresent() throws IOException, InterruptedException {
        test= Reports.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), reports);
        try {
            softAssert.assertEquals(homePage.validateIsTitlePresent(PropertyReaderOptimized.getKeyValue("title"),test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        } catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 2)
    public void verifyIsHomePageHeaderLogoPresent() throws IOException {
        test=Reports.createTest(new Object(){}.getClass().getEnclosingMethod().getName(),reports);
        try
        {
            softAssert.assertEquals(homePage.validateIsHomePageHeaderLogoPresent(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        }catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 3)
    public void verifyIsHomeHeaderCoinHubButtonPresent() throws IOException {
        test=Reports.createTest(new Object(){}.getClass().getEnclosingMethod().getName(),reports);
        try
        {
            softAssert.assertEquals(homePage.validateIsHomeHeaderCoinHubButtonPresent(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        }catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 4)
    public void verifyIsHomePageHeaderOutTokenButtonPresent() throws IOException {
        test=Reports.createTest(new Object(){}.getClass().getEnclosingMethod().getName(),reports);
        try
        {
            softAssert.assertEquals(homePage.validateIsHomePageHeaderOutTokenButtonPresent(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        }catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 5)
    public void verifyIsHomePageHeaderEcosystemButtonPresent() throws IOException {
        test=Reports.createTest(new Object(){}.getClass().getEnclosingMethod().getName(),reports);
        try
        {
            softAssert.assertEquals(homePage.validateIsHomePageHeaderEcosystemButtonPresent(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        }catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 6)
    public void verifyIsHomePageHeaderMarketUpdatesButtonPresent() throws IOException {
        test=Reports.createTest(new Object(){}.getClass().getEnclosingMethod().getName(),reports);
        try
        {
            softAssert.assertEquals(homePage.validateIsHomePageHeaderMarketUpdatesButtonPresent(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        }catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 7)
    public void verifyIsHomePageHeaderExchangeButtonPresent() throws IOException {
        test=Reports.createTest(new Object(){}.getClass().getEnclosingMethod().getName(),reports);
        try
        {
            softAssert.assertEquals(homePage.validateIsHomePageHeaderExchangeButtonPresent(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        }catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

//    @Test(priority = 8)
//    public void verifyIsHomePageHeaderDemoTradingButtonPresent() throws IOException {
//        test=Reports.createTest(new Object(){}.getClass().getEnclosingMethod().getName(),reports);
//        try
//        {
//            softAssert.assertEquals(homePage.validateIsHomePageHeaderDemoTradingButtonPresent(test),true);
//            test.log(LogStatus.PASS,"All conditions are verified.");
//        }catch (Error | Exception e) {
//            test.log(LogStatus.FAIL,"All conditions aren't verified.");
//            Assert.fail(String.valueOf(e.getStackTrace()));
//            softAssert.assertAll();
//        }
//    }

    @Test(priority = 9)
    public void verifyIsHomePageHeaderLoginButtonPresent() throws IOException {
        test=Reports.createTest(new Object(){}.getClass().getEnclosingMethod().getName(),reports);
        try
        {
            softAssert.assertEquals(homePage.validateIsHomePageHeaderLoginButtonPresent(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        }catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 10)
    public void verifyIsHomePageHeaderRegisterButtonPresent() throws IOException {
        test=Reports.createTest(new Object(){}.getClass().getEnclosingMethod().getName(),reports);
        try
        {
            softAssert.assertEquals(homePage.validateIsHomePageHeaderRegisterButtonPresent(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        }catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 11)
    public void verifyHomePageSocialMediaLinksPresent() throws IOException, InterruptedException {
        test=Reports.createTest(new Object(){}.getClass().getEnclosingMethod().getName(),reports);
        try
        {
            softAssert.assertEquals(homePage.validateIsSocialMediaLinksPresent(test),true);
            test.log(LogStatus.PASS,"Verified all conditions are verified.");
        }catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"Verified all conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 12)
    public void verifyIsHomePageFooterComponentsPresent() throws IOException {
        test=Reports.createTest(new Object(){}.getClass().getEnclosingMethod().getName(),reports);
        try
        {
            softAssert.assertEquals(homePage.isFooterComponentsPresent(test),true);
            test.log(LogStatus.PASS,"All conditions are verified.");
        }catch (Error | Exception e) {
            test.log(LogStatus.FAIL,"All conditions aren't verified.");
            Assert.fail(String.valueOf(e.getStackTrace()));
            softAssert.assertAll();
        }
    }
}
