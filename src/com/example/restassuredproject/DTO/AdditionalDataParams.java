package com.example.restassuredproject.DTO;

import com.example.restassuredproject.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class AdditionalDataParams {
    private String storeLabel;
    private String terminalLabel;

    UTIL util=new UTIL();
    Properties prop = util.readPropData();

    public AdditionalDataParams() throws IOException {
    }

    String storeLabel_prop = prop.getProperty("storeLabel");
    String terminalLabel_prop = prop.getProperty("terminalLabel");

    public String getStoreLabel() {
        return storeLabel;
    }

    public void setStoreLabel(String storeLabel) {
        this.storeLabel = storeLabel_prop;
    }

    public String getTerminalLabel() {
        return terminalLabel;
    }

    public void setTerminalLabel(String terminalLabel) {
        this.terminalLabel = terminalLabel_prop;
    }
}
