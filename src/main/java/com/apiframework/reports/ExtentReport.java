package com.apiframework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {
    private static ExtentReports reports;
    private ExtentReport(){}

    public static void initReport(){
        reports=new ExtentReports();
        ExtentSparkReporter spark=new ExtentSparkReporter("index.html");
        reports.attachReporter(spark);
    }
    public static void tearDownReport(){
        reports.flush();
    }

    public static void createTest(String testName){
        ExtentManager.setTest(reports.createTest(testName));
    }
    public static void addAuthor(String[] authors){
        for(String author:authors){
            ExtentManager.getTest().assignAuthor(author);
        }
    }
    public static void addCategory(String[] categories){
        for(String category:categories){
            ExtentManager.getTest().assignCategory(category);
        }
    }
}
