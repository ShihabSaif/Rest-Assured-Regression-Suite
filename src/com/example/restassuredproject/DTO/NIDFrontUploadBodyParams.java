package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NIDFrontUploadBodyParams {

    private String nidNo;
    private String nidType;
    private String requestId;
    private  String photoFrontSide;

    public String getTkMobileNo() {
        return tkMobileNo;
    }

    public void setTkMobileNo(String tkMobileNo) {
        this.tkMobileNo = tk_mobile_no;
    }

    private String tkMobileNo;

    //Read data from property file
    UTIL util=new UTIL();
    Properties prop = util.readPropData();
    String nid_no_prop= prop.getProperty("nid_no_prop");
    String nid_type_prop= prop.getProperty("nid_type_prop");
    String nid_pic_prop= prop.getProperty("nid_pic_prop");
    String tk_mobile_no = prop.getProperty("phn_number");
    public static final String reqID = UTIL.generateRandomRequestId();

    byte[] fileContent = FileUtils.readFileToByteArray(new File("nid_front_shihab.jpg"));
    String encodedString = Base64.getEncoder().encodeToString(fileContent);

    public NIDFrontUploadBodyParams() throws IOException {
    }


    public String getNidNo() {
        return nidNo;
    }

    public void setNidNo(String nidNo) {
        this.nidNo = nid_no_prop;
    }

    public String getNidType() {
        return nidType;
    }

    public void setNidType(String nidType) {
        this.nidType = nid_type_prop;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = reqID;
    }

    public String getPhotoFrontSide() {
        return photoFrontSide;
    }

    public void setPhotoFrontSide(String photoFrontSide) {
        this.photoFrontSide = encodedString;
    }



}
