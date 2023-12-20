package com.apiframework.constants;

import lombok.Getter;

public class FrameworkConstants {
    private static @Getter final String request_json_folder_path=System.getProperty("user.dir") + "/src/test/resources/jsons/";
    private static @Getter final String response_json_folder_path=System.getProperty("user.dir") + "/output/";
    private static @Getter final String Property_path=System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
}