package com.apiframework.builder;

import com.apiframework.enums.PropertyType;
import com.apiframework.utils.PropertyUtils;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RequestBuilder {
    private RequestBuilder() {

    }
   public static RequestSpecification buildRequestForGetCalls() {
        return given()
                .baseUri(PropertyUtils.getValue(PropertyType.BASEURL))
                .log()
                .all();

    }
    public static RequestSpecification buildRequestForPostCalls() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(PropertyUtils.getValue(PropertyType.BASEURL))
                .log()
                .all();

    }
}
