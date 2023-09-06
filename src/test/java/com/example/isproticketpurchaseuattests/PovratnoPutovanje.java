package com.example.isproticketpurchaseuattests;

import static com.codeborne.selenide.Selenide.$;

public class PovratnoPutovanje {
    public static void odaberiPovratno(){
        $("#returnJourneyRadio").click();
        System.out.println("\nOdabrano povratno putovanje. \n");
    }
}
