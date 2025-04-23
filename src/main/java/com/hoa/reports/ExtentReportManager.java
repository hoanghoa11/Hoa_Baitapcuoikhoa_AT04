package com.hoa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.hoa.helpers.PropertiesHelper;

public class ExtentReportManager {

    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        PropertiesHelper.loadAllFiles();
        ExtentSparkReporter reporter = new ExtentSparkReporter("EXTENT_REPORT_PATH");
        reporter.config().setReportName("Extent Report | Anh Tester");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java | Anh Tester");
        extentReports.setSystemInfo("Author", "Anh Tester");
        return extentReports;
    }

}

