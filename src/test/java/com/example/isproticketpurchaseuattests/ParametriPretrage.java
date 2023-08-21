package com.example.isproticketpurchaseuattests;

import static com.codeborne.selenide.Selenide.$x;

public class ParametriPretrage {
    public static void fillData(String odlazno, String povratno ){
        $x("//label[text()='Polazni kolodvor']/following-sibling::span/input").sendKeys(odlazno);
        $x("//label[text()='Odredišni kolodvor']/following-sibling::span/input").sendKeys(povratno);
    }
}
