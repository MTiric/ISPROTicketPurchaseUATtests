package com.example.isproticketpurchaseuattests;

import static com.codeborne.selenide.Selenide.$x;

public class UserDataRegistration {

    public static void fillInfo(String user, String pass){
        $x("//input[@id='fUsername']").sendKeys(user);
        $x("//input[@id='fPassword']").sendKeys(pass);
        $x("//button[@id='korisnikSubmitButton']").click();
    }
}
