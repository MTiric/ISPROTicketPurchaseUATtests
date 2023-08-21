package com.example.isproticketpurchaseuattests;

import static com.codeborne.selenide.Selenide.$;

public class UserDataNoRegistration {
    public static void fillInfo(){
        $("[data-tab=\"tab-2\"]").click();
        $("#UserDetails_Email").sendKeys("testmail@harakirimail.com");
        $("#UserDetails_FirstName").sendKeys("TestName");
        $("#UserDetails_LastName").sendKeys("TestSurname");
        $("#UserDetails_Address").sendKeys("TestAddress 72");
        $("#UserDetails_PostCode").sendKeys("73579057");
        $("#UserDetails_City").sendKeys("Test City");
        $("#userNoRegistrationSubmit").click();
    }
}
