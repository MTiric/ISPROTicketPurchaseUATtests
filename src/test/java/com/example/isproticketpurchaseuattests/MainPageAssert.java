package com.example.isproticketpurchaseuattests;

import com.codeborne.selenide.SelenideElement;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPageAssert {
    public static void assertMainPage(){
        $("#searchViewWrapper").shouldBe(visible);
    }

    public static String assertSearch(String polaznaStanica, String povratnaStanica){
        SelenideElement searchRelation = $x("//h4[text()='" + polaznaStanica + " → " + povratnaStanica +"']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        return searchRelationActualResult;
    }
}
