package com.apiframework.listeners;

import com.apiframework.annotations.FrameworkAnnotation;
import com.apiframework.reports.ExtentLogger;
import com.apiframework.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TestListener implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.tearDownReport();
    }
    @Override
    public void onTestStart(ITestResult result) {
        String description = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description();
        ExtentReport.createTest(description);
        String[] authors = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author();
        ExtentReport.addAuthor(authors);
        String[] categories = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category();
        ExtentReport.addCategory(categories);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName()+"is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(String.valueOf(result.getThrowable()));
        //  String jiraIssue = JiraUtils.createJiraIssue(String.valueOf(result.getThrowable()));
        //  ExtentLogger.fail(("Issue created in Jira:"+"http://localhost:8080/rest/api/2/issue/"+jiraIssue));
    }
}

