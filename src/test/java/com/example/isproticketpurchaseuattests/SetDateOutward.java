package com.example.isproticketpurchaseuattests;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class SetDateOutward {
    public static void setDate(int dateDifference){
        $("#DepartureDate").clear();
        $("#DepartureDate").sendKeys(DifferentDateTime.returnFuture(dateDifference), Keys.ENTER);//this inputs tomorrow date
    }
}
