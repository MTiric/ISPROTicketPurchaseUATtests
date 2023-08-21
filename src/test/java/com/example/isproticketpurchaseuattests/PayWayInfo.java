package com.example.isproticketpurchaseuattests;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PayWayInfo {
    public static void fillInfo(){
        $("#creditCardNumber").sendKeys("4574180527069023");
        $("#exp_date").sendKeys("11/23");
        $("#cvv_code").sendKeys("000");
        $("#customer_phone").sendKeys("099999999");

        $x("//button[@type='submit']").click();

        $x("//button[@type='submit']").click();
    }
}
