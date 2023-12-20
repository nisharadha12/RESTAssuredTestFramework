package com.apitests;

import com.apiframework.annotations.FrameworkAnnotation;
import com.apiframework.builder.RequestBuilder;
import com.apiframework.constants.FrameworkConstants;
import com.apiframework.constants.RequestEndPoints;
import com.apiframework.reports.ExtentLogger;
import com.apiframework.utils.ApiUtils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import static com.apiframework.utils.TestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(response.getStatusCode())
                .isEqualTo(201);
        ApiUtils.storeStringAsJasonFile(FrameworkConstants.getResponse_json_folder_path()+method.getName()+"response.json",response);
    }
}


