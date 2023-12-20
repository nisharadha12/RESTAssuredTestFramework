package com.apiframework.utils;

import com.apiframework.constants.FrameworkConstants;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public final class JiraUtils {
    private JiraUtils() {
    }

    @Test
    public static String createJiraIssue(String errorMassege) {

        String stringRequest = ApiUtils.readJsonAndGetAsString(FrameworkConstants.getRequest_json_folder_path() + "jiraissue.json")
                .replace("TEST", "DEM")
                .replace("Summary", errorMassege)
                .replace("details", "Creating of an issue using project keys and issue type names using the REST API");

        Response response = given()
                .config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Authorization")))
                .contentType(ContentType.JSON)
                .header("Authorization","Basic")
                .body(stringRequest)
                .log()
                .all()
                .post(" http://localhost:8080/rest/api/2/issue/");
        response.prettyPrint();
        return response.jsonPath().getString("key");
    }
}
