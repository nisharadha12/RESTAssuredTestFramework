package com.apitests.tests;

import com.apiframework.annotations.FrameworkAnnotation;
import com.apiframework.builder.RequestBuilder;
import com.apiframework.constants.RequestEndPoints;
import com.apiframework.reports.ExtentLogger;
import com.apitests.assertions.ResponseAssert;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class GetUserTest {

    @Test(description = "Validating All Users")
    @FrameworkAnnotation(author = "Nisha",category = {"Smoke","get calls"})
    public void getUserDetails(){

        Response response= RequestBuilder.buildRequestForGetCalls()
                .get(RequestEndPoints.getGetUserEndPoint());

        ExtentLogger.logMessage(response.asPrettyString());

        ResponseAssert.assertThat(response)
                        .isStatusCode(HttpStatus.SC_OK);

    }

    @Test(dataProvider = "getData",description = "Validating single user")
    @FrameworkAnnotation(author = "Nisha",category = {"Regression","get calls"})
    public void validateStudentDetails(int id,String lastname){
        Response response= RequestBuilder.buildRequestForGetCalls()
                .pathParam("id",id)
                .get(RequestEndPoints.getGetUserEndPoint()+"/{id}");
        response.prettyPrint();
        ExtentLogger.logMessage(response.asPrettyString());

//        assertThat(response.getStatusCode())
//                .isEqualTo(HttpStatus.SC_OK);
//
//        assertThat(response.jsonPath().getMap("$").size())
//                .isPositive()
//                .as("validating size")
//                .isLessThan(3);
//        System.out.println("Size"+response.jsonPath().getMap("$").size());
//        assertThat((response.jsonPath().getString("data.last_name")))
//                .as("Comparing the last name in the response")
//                .isEqualTo(lastname)
//                .hasSizeBetween(3,20);
        ResponseAssert.assertThat(response)
                .isStatusCode(HttpStatus.SC_OK)
                .hasResponseSize(3)
                .hasLastName(lastname);

    }

    @DataProvider
    public Object[][] getData(){
        return  new Object[][]{
                {7,"Lawson"},
                {8,"Ferguson"},
                {12,"Howell"}
        };
    }
}
