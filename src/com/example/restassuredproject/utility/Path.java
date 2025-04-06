package com.example.restassuredproject.utility;

public class Path {
    public static final String xpathNAme = "//input[@id='nameOnCard' and @type='text' and @aria-describedby='cardholder-name-error']";
    public static final String xpathForCardNAme = "//div[@class='input-group input-group-sm']/div[@class='form-control form-control-sm w-100 fake-input']/input[@id='id='name-on-card-exactly-shown-on-card']";
    public static final String xPathForNagadAcc1 = "//input[@type='number' and @class='form-control']";
    public static final String xPathForNagadForwardButton = "//button[@class='btn translateable bn' and @type='submit' and contains(.,'এগিয়ে যান')]";
    public static final String xPathForErrorMessage = "//div[@class='messages']/span[@class='text-error']";
    public static final String xPathForPin = "//div[@class='box-inputs pin-input']/input[@type='password' and @class='form-control' and @inputmode='numeric']";
    public static final String xPathForPorishodButton = "//span[@class='py-2 btn btn-danger btn-block round bn-semibold' and contains(.,'পরিশোধ করি')]";
    public static final String xPathForClickNagadButton = "//div[@class='d-flex align-items-center justify-content-between']/span[@class='text bn-regular' and contains(.,'নগদ')]";
    public static final String xPathCCNagadError = "//div[@class='bn-regular message-font' and contains(.,'আপনার পেমেন্টটি সফল')]";
    public static final String xPathForClickCardButton = "//div[@class='d-flex align-items-center justify-content-between']/span[@class='text bn-regular' and contains(.,'ভিসা/মাস্টারকার্ড')]";
    public static final String xPathForSuccessMessagePath = "//div[@class='d-flex flex-column color-black']/span[@class='bn-regular' and contains(.,'আপনার পেমেন্ট সফল হয়েছে।')]";
}
