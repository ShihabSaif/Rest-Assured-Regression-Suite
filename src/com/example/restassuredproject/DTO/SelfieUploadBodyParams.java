package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public class SelfieUploadBodyParams {
    private String profilePicture;
    private String requestId;
    private String nidNo;

    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    byte[] fileContent = FileUtils.readFileToByteArray(new File("selfie_shihab.jpg"));
    String encodedString = Base64.getEncoder().encodeToString(fileContent);

    String request_id_prop = UTIL.generateRandomRequestId();
    String nid_no_prop = prop.getProperty("nid_no_prop");

    public SelfieUploadBodyParams() throws IOException {
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = encodedString;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = request_id_prop;
    }

    public String getNidNo() {
        return nidNo;
    }

    public void setNidNo(String nidNo) {
        this.nidNo = nid_no_prop;
    }
}
