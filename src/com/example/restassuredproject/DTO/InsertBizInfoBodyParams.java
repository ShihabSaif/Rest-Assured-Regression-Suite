package com.example.restassuredproject.DTO;

public class InsertBizInfoBodyParams {
    private BusinessInfoBodyParams businessInfo;
    private WalletInfoBodyParams walletInfo;

    public BusinessInfoBodyParams getBusinessInfo() {
        return businessInfo;
    }

    public void setBusinessInfo(BusinessInfoBodyParams businessInfo) {
        this.businessInfo = businessInfo;
    }

    public WalletInfoBodyParams getWalletInfo() {
        return walletInfo;
    }

    public void setWalletInfo(WalletInfoBodyParams walletInfo) {
        this.walletInfo = walletInfo;
    }
}
