package com.example.isproticketpurchaseuattests;

import static com.codeborne.selenide.Selenide.$x;

public class ParametriPretrage {
    String polaznaStanica;
    String odredisnaStanica;

    int datumPolaska;
    int datumPovratka;

    public ParametriPretrage(String polStanica, String povStanica){
        polaznaStanica = polStanica;
        odredisnaStanica = povStanica;
        fillData(polaznaStanica, odredisnaStanica);
    }
    public static void fillData(String odlazno, String povratno ){
        $x("//label[text()='Polazni kolodvor']/following-sibling::span/input").sendKeys(odlazno);
        $x("//label[text()='Odredišni kolodvor']/following-sibling::span/input").sendKeys(povratno);
    }

    public static void selectAllTrains(){
        $x("//input[@id='DirectTrains'][@value='false']").click(); //clicks on "All trains" radio button(svi vlakovi)
    }
}
