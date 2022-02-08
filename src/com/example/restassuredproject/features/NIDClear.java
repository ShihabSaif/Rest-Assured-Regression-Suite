package com.example.restassuredproject.features;

import com.example.restassuredproject.model.User;
import com.example.restassuredproject.utility.APIPath;
import com.example.restassuredproject.utility.UTIL;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Properties;


import static io.restassured.RestAssured.given;
public class NIDClear {

    /*@Autowired
    private ReadFromPropertiesFile readFromPropertiesFile;*/


    public Response nidClear(User user) throws IOException {
        RestAssured.baseURI= APIPath.hostURLForNIDClear;

        //Read from application.properties file
        /*ReadFromPropertiesFile readFromPropertiesFile=new ReadFromPropertiesFile();
        String nid=readFromPropertiesFile.postConstruct();*/

        UTIL util = new UTIL();
        Properties prop = util.readPropData();
        String nid_no_prop= prop.getProperty("nid_no_prop");


        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/backend/nid/"+ nid_no_prop +"/reset-nid")
                .then()
                .extract().response();
        return response;
    }
}
