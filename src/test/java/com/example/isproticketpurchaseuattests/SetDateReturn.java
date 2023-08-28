package com.example.isproticketpurchaseuattests;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class SetDateReturn {
    public static void setDate(int dateDifference){
        $("#ReturnDepartureDate").clear();
        $("#ReturnDepartureDate").sendKeys(DifferentDateTime.returnFuture(dateDifference), Keys.ENTER);//this inputs day after tomorrow
    }
}
