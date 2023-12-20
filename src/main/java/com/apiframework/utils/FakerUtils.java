package com.apiframework.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

    private static final Faker faker=new Faker();
    private  FakerUtils(){}
    static int getNumber(int start,int end){
        return faker.number().numberBetween(start,end);
    }
    static String getFirstName(){
        return faker.name().firstName();
    }
    static String getLastName(){
        return faker.name().lastName();
    }
    static String getUserJob(){return  faker.job().field();}
}
