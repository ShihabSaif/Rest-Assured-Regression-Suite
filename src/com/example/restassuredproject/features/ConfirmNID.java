package com.example.restassuredproject.features;

import com.example.restassuredproject.DTO.ConfirmNIDInfoParams;
import com.example.restassuredproject.testClasses.TestClassForSignUp;
import com.example.restassuredproject.utility.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ConfirmNID {

    public Response confirmNIDResponse(){
        RestAssured.baseURI= APIPath.hostURLMain;

        ConfirmNIDInfoParams confirmNIDInfoParams=new ConfirmNIDInfoParams();
        confirmNIDInfoParams.setSpouseName(confirmNIDInfoParams.getSpouseName());
        confirmNIDInfoParams.setNidNo(confirmNIDInfoParams.getNidNo());
        confirmNIDInfoParams.setAddressPermanent(confirmNIDInfoParams.getAddressPermanent());
        confirmNIDInfoParams.setBirthday(confirmNIDInfoParams.getBirthday());
        confirmNIDInfoParams.setBloodGroup(confirmNIDInfoParams.getBloodGroup());
        confirmNIDInfoParams.setCustomerNameBn(confirmNIDInfoParams.getCustomerNameBn());
        confirmNIDInfoParams.setCustomerNameEn(confirmNIDInfoParams.getCustomerNameEn());
        confirmNIDInfoParams.setGender(confirmNIDInfoParams.getGender());
        confirmNIDInfoParams.setMonthlyIncome(confirmNIDInfoParams.getMonthlyIncome());
        confirmNIDInfoParams.setFatherName(confirmNIDInfoParams.getFatherName());
        confirmNIDInfoParams.setMotherName(confirmNIDInfoParams.getMotherName());
        confirmNIDInfoParams.setOccupation(confirmNIDInfoParams.getOccupation());


        //body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON).headers("Authorization","token " + TestClassForSignUp.token);

        //response
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .when()
                .body(confirmNIDInfoParams)
                .header("Content-Type", "application/json")
                .post("/api/v1/user/doc/confirm-nid-info").prettyPeek().then().extract().response();
        return response;
    }
}
