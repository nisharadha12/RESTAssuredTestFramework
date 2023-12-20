package com.apiframework.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
    public static ThreadLocal<ExtentTest> test=new ThreadLocal<>();
    private ExtentManager(){}
    static ExtentTest getTest() {
        return test.get();
    }
    static void setTest(ExtentTest testName){
        test.set(testName);
    }
}

