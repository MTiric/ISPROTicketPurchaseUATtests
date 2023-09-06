package com.example.isproticketpurchaseuattests;

import static com.codeborne.selenide.Selenide.$;

public class ConditionsOfSaleScreen {
    public static void acceptGeneralConditionsOfSale(){
        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
    }
}
