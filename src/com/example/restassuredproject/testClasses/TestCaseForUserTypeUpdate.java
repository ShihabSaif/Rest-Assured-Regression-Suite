package com.example.restassuredproject.testClasses;

import com.example.restassuredproject.features.nagadCashOut;
import com.example.restassuredproject.features.UpdateUserType;
import com.example.restassuredproject.model.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;

@Test(priority = 16,alwaysRun = true, enabled = true)
public class TestCaseForUserTypeUpdate {
    public static User user = new User();
    public static UpdateUserType userUpdate = new UpdateUserType();
    public void testCashOut() throws IOException {
        Response response= userUpdate.updateUserType(user);
        JsonPath jsonPathEvaluator = response.jsonPath();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        jsonPathEvaluator.prettyPrint();
        System.out.println("Response Body is: " + body.asString());

        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}
