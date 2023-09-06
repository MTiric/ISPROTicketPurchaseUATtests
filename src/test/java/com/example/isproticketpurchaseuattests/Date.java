package com.example.isproticketpurchaseuattests;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class Date {
    public static void setDateOutward(int dateDifference){
        $("#DepartureDate").clear();
        $("#DepartureDate").sendKeys(DifferentDateTime.returnFuture(dateDifference), Keys.ENTER);//this inputs tomorrow date
        System.out.println("Datum putovanja polazno: " + DifferentDateTime.returnFuture(dateDifference));
    }
    public static void setDateReturn(int dateDifference){
        $("#ReturnDepartureDate").clear();
        $("#ReturnDepartureDate").sendKeys(DifferentDateTime.returnFuture(dateDifference), Keys.ENTER);//this inputs day after tomorrow
        System.out.println("Datum putovanja povratno: " + DifferentDateTime.returnFuture(dateDifference));
    }
}
