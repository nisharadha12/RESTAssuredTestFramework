package com.apiframework.utils;

import com.apiframework.constants.FrameworkConstants;
import com.apiframework.enums.PropertyType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils() {
    }
    private static Properties properties = new Properties();
    private static Map<String,String> propertyMap=new HashMap<>();
    static  {
        try (FileInputStream inputStream=new FileInputStream(FrameworkConstants.getProperty_path())){
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        properties.entrySet().forEach(e->propertyMap.put(String.valueOf(e.getKey()),String.valueOf(e.getValue())));
    }

    public static String getValue(PropertyType key){
        return propertyMap.get(key.name().toLowerCase());
    }
}

