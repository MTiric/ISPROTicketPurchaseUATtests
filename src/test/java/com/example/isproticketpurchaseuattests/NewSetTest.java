package com.example.isproticketpurchaseuattests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

public class NewSetTest {

    MainPage mainPage = new MainPage();
    String urlMain = "https://prodaja-test.hzpp.hr/";
    String fareGoPRODIP = "http://10.215.100.26";


    @BeforeSuite
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 90000;
        Configuration.pageLoadTimeout = 90000;
        //Configuration.timeout = 300000;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        Selenide.clearBrowserCookies();
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");


        open(urlMain);


    }

    @Test
    public void fareGoCheckStatus() {


        open(fareGoPRODIP);

    }

}
