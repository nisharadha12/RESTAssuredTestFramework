package com.apiframework.utils;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public final class ApiUtils {

    private ApiUtils(){

    }
    @SneakyThrows
    public static String readJsonAndGetAsString(String filepath)  {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }

    @SneakyThrows
    public static void storeStringAsJasonFile(String filepath, Response response){
        Files.write(Paths.get(filepath),response.asByteArray());
    }
}
