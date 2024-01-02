package com.apitests.tests;

import com.apiframework.annotations.FrameworkAnnotation;
import com.apiframework.builder.RequestBuilder;
import com.apiframework.constants.FrameworkConstants;
import com.apiframework.constants.RequestEndPoints;
import com.apiframework.reports.ExtentLogger;
import com.apiframework.utils.ApiUtils;
import com.apitests.assertions.ResponseAssert;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import static com.apiframework.utils.TestUtils.*;

public class CreateUserTest {


    @Test(description = "Validating Create new Users")
    @FrameworkAnnotation
    public  void createUserTest(Method method){
        String resource = ApiUtils.readJsonAndGetAsString(FrameworkConstants.getRequest_json_folder_path()+"request.json")
                .replace("first_name", getName())
                .replace("job_title",getJob());

        RequestSpecification requestSpecification=RequestBuilder.buildRequestForPostCalls()
                .body(resource);
        ExtentLogger.logRequest(requestSpecification);

        Response response =requestSpecification.post(RequestEndPoints.getGetUserEndPoint());
        response.prettyPrint();

        ExtentLogger.logMessage(response.asPrettyString());

        ResponseAssert.assertThat(response)
                        .isStatusCode(HttpStatus.SC_CREATED);
        ApiUtils.storeStringAsJasonFile(FrameworkConstants.getResponse_json_folder_path()+method.getName()+"response.json",response);
    }
}


