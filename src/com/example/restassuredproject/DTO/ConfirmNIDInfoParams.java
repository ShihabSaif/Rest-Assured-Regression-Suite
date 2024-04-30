package com.example.restassuredproject.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import static com.example.restassuredproject.testClasses.TestCaseForNIDFrontUpload.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfirmNIDInfoParams {
    private String customerNameBn;
    private String customerNameEn;
    private String nidNo;
    private String gender;
    private String addressPermanent;
    private String addressPresent;
    private String birthday;
    private String fatherName;
    private String motherName;
    private String occupation;
    private String spouseName;
    private String bloodGroup;
    private String monthlyIncome;

    public String getCustomerNameBn() {
        return customerNameBn;
    }

    public void setCustomerNameBn(String customerNameBn) {
        this.customerNameBn = customerNameBn1;
    }

    public String getCustomerNameEn() {
        return customerNameEn;
    }

    public void setCustomerNameEn(String customerNameEn) {
        this.customerNameEn = customerNameEn1;
    }

    public String getNidNo() {
        return nidNo;
    }

    public void setNidNo(String nidNo) {
        this.nidNo = nidNo1;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender1;
    }

    public String getAddressPermanent() {
        return addressPermanent;
    }

    public void setAddressPermanent(String addressPermanent) {
        this.addressPermanent = addressPermanent1;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday1;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName1;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName1;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation1;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName1;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup1;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome1;
    }

    public String getAddressPresent() {
        return addressPresent;
    }

    public void setAddressPresent(String addressPresent) {
        this.addressPresent = addressPresent1;
    }
}
