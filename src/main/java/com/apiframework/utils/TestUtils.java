package com.apiframework.utils;

public final class TestUtils {
    private TestUtils(){}
    public static int getId(){
        return FakerUtils.getNumber(100,900);
    }
    public static String getName(){
        return FakerUtils.getFirstName().toLowerCase();
    }
    public static String getLastName(){
        return  FakerUtils.getLastName().toLowerCase();
    }
    public static String getJob(){return  FakerUtils.getUserJob().toLowerCase();}
}
