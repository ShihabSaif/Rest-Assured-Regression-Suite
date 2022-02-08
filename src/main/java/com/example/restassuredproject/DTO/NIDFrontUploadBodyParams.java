package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class NIDFrontUploadBodyParams {

    //Read data from property file
    public static final String random_req_id = UTIL.generateRandomRequestId();
    UTIL util=new UTIL();
    Properties prop = util.readPropData();
    String nid_no_prop= prop.getProperty("nid_no_prop");
    String nid_type_prop= prop.getProperty("nid_type_prop");
    String nid_pic_prop= prop.getProperty("nid_pic_prop");

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
        this.requestId = random_req_id;
    }

    public String getPhotoFrontSide() {
        return photoFrontSide;
    }

    public void setPhotoFrontSide(String photoFrontSide) {
        this.photoFrontSide = nid_pic_prop;
    }

    private String nidNo;
    private String nidType;
    private String requestId;
    private String photoFrontSide;

}
