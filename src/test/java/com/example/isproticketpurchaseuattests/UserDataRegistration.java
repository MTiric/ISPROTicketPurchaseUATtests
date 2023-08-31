package com.example.isproticketpurchaseuattests;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UserDataRegistration {

    public static void fillInfo(){
        $x("//input[@id='fUsername']").sendKeys("matko.tiric@king-ict.hr");
        $x("//input[@id='fPassword']").sendKeys("KingMT329!");
        $x("//button[@id='korisnikSubmitButton']").click();
    }
}
