package com.report;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reports {
    WebDriver driver;
    static ExtentReports reports;
    static ExtentTest test;
    public static ExtentReports getReportObject()
    {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        return reports=new ExtentReports("D:\\AutomationReports\\AutomationReportsResult_+"+timeStamp+"+.html");
    }
    public static ExtentTest createTest(String testCaseName,ExtentReports reports)
    {
        return test=reports.startTest(testCaseName);
    }
    public void flushReport(ExtentReports reports,ExtentTest test){
        reports.endTest(test);
        reports.flush();
    }
}
