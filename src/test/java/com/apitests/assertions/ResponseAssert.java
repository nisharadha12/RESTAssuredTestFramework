package com.apitests.assertions;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import java.util.concurrent.TimeUnit;

public class ResponseAssert extends AbstractAssert<ResponseAssert,Response> {

    private ResponseAssert(Response response, Class<?> selfType) {
        super(response, selfType);
    }

    public static ResponseAssert assertThat(Response response){
        return new ResponseAssert(response,ResponseAssert.class);
    }

    public ResponseAssert isStatusCode(int statusCode){
        Assertions.assertThat(actual.getStatusCode())
                .as("Status Code assertion")
                .withFailMessage(()->"Status code is not 201")
                .isEqualTo(statusCode);

        return this;
    }
    public ResponseAssert containsHeaderApplicationJson() {
        Assertions.assertThat(actual.header("Content-Type"))
                .withFailMessage(() -> "Response does not contain Header with Content-Type as application/json")
                .contains("application/json");
        return this;
    }
    public ResponseAssert hasResponseTimeWithinTwoSecs() {
        Assertions.assertThat(actual.getTimeIn(TimeUnit.SECONDS))
                .withFailMessage(() -> "Response time is not within 2 seconds")
                .isLessThanOrEqualTo(2000);
        return this;
    }

  public ResponseAssert hasResponseSize(int size){
        Assertions.assertThat(actual.jsonPath().getMap("$").size())
                .isPositive()
                .as("Validating Size")
                .withFailMessage("()->Response size is less than "+size)
                .isLessThan(size);
        return this;
    }
    public ResponseAssert hasLastName(String lastname){
        Assertions.assertThat(actual.jsonPath().getString("data.last_name"))
                .as("Comparing the last name in the response")
                .isEqualTo(lastname)
                .hasSizeBetween(3,20);
        return this;
    }

}
