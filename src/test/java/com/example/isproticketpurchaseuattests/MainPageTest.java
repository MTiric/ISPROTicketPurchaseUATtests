package com.example.isproticketpurchaseuattests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;


public class MainPageTest {
    MainPage mainPage = new MainPage();
    EnvironmentDataUAT environmentDataUAT = new EnvironmentDataUAT();


    SoftAssert softAssert = new SoftAssert();

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
        //Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");

        System.out.println("\n-----------------------Test start---------------------------\n");
        open(environmentDataUAT.urlMain);


    }

    @AfterMethod
    public void status(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.SUCCESS) {
                System.out.println("\n\nRESULT: SUCCESS");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                // Do something here
                System.out.println("\n##############################\n##########################RESULT: FAILURE");
            } else if (result.getStatus() == ITestResult.SKIP) {
                System.out.println("##########################RESULT: SKIP");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n-----------------------Test finish---------------------------\n");
    }

    @Test(description = "Jednosmjerno putovanje normalna karta")
    public void jednosmjernoPutovanjeNormalnaKartaTest() {
        System.out.println("Jednosmjerno putovanje normalna karta");

        MainPageAssert.assertMainPage();

        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");

        Date.setDateOutward(1);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();


        softAssert.assertEquals(MainPageAssert.assertSearch(parametriPretrage.polaznaStanica, parametriPretrage.odredisnaStanica),
                parametriPretrage.polaznaStanica + " → " + parametriPretrage.odredisnaStanica,
                "Relation is not matching");
        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here

        PayWayInfo.fillInfo();
        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjeNormalnaKarta() {
        System.out.println("povratnoPutovanjeNormalnaKarta");


        MainPageAssert.assertMainPage();
        PovratnoPutovanje.odaberiPovratno();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");
        Date.setDateOutward(1);
        Date.setDateReturn(1);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        softAssert.assertEquals(MainPageAssert.assertSearch(parametriPretrage.polaznaStanica, parametriPretrage.odredisnaStanica),
                parametriPretrage.polaznaStanica + " → " + parametriPretrage.odredisnaStanica,
                "Relation is not matching");
        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        mainPage.continueAfterTrainSelect.click();
        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeSviVlakovi() {
        System.out.println("povratnoPutovanjeNormalnaKarta");

        MainPageAssert.assertMainPage();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");

        ParametriPretrage.selectAllTrains();

        Date.setDateOutward(1);
        mainPage.pretrazi.click();

        softAssert.assertEquals(MainPageAssert.assertSearch(parametriPretrage.polaznaStanica, parametriPretrage.odredisnaStanica),
                parametriPretrage.polaznaStanica + " → " + parametriPretrage.odredisnaStanica,
                "Relation is not matching");
        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here

        PayWayInfo.fillInfo();
        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjeSviVlakovi() {
        System.out.println("povratnoPutovanjeSviVlakovi");

        MainPageAssert.assertMainPage();
        PovratnoPutovanje.odaberiPovratno();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");
        ParametriPretrage.selectAllTrains();

        Date.setDateOutward(1);
        Date.setDateReturn(1);
        mainPage.pretrazi.click();

        softAssert.assertEquals(MainPageAssert.assertSearch(parametriPretrage.polaznaStanica, parametriPretrage.odredisnaStanica),
                parametriPretrage.polaznaStanica + " → " + parametriPretrage.odredisnaStanica,
                "Relation is not matching");
        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        mainPage.continueAfterTrainSelect.click();
        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");
        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeTriPutnika() {
        System.out.println("jednosmjernoPutovanjeTriPutnika");

        MainPageAssert.assertMainPage();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");
        Date.setDateOutward(1);
        mainPage.increasePassengerCount.doubleClick();
        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        softAssert.assertEquals(MainPageAssert.assertSearch(parametriPretrage.polaznaStanica, parametriPretrage.odredisnaStanica),
                parametriPretrage.polaznaStanica + " → " + parametriPretrage.odredisnaStanica,
                "Relation is not matching");
        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjeTriPutnika() {
        System.out.println("povratnoPutovanjeTriPutnika");

        MainPageAssert.assertMainPage();
        PovratnoPutovanje.odaberiPovratno();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");
        Date.setDateOutward(1);
        Date.setDateReturn(1);
        mainPage.increasePassengerCount.doubleClick();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();


        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        mainPage.continueAfterTrainSelect.click();
        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeSestPutnika() {
        System.out.println("jednosmjernoPutovanjeSestPutnika");

        MainPageAssert.assertMainPage();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");
        Date.setDateOutward(1);
        mainPage.increasePassengerCount.doubleClick();
        mainPage.decreasePassengerCount.click();
        mainPage.increasePassengerCount.doubleClick();
        mainPage.decreasePassengerCount.click();
        mainPage.increasePassengerCount.doubleClick();
        mainPage.decreasePassengerCount.click();
        mainPage.increasePassengerCount.doubleClick();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();


        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjeSestPutnika() {
        System.out.println("povratnoPutovanjeSestPutnika");


        MainPageAssert.assertMainPage();
        PovratnoPutovanje.odaberiPovratno();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");
        Date.setDateOutward(1);
        Date.setDateReturn(1);
        mainPage.increasePassengerCount.doubleClick();
        mainPage.decreasePassengerCount.click();
        mainPage.increasePassengerCount.doubleClick();
        mainPage.decreasePassengerCount.click();
        mainPage.increasePassengerCount.doubleClick();
        mainPage.decreasePassengerCount.click();
        mainPage.increasePassengerCount.doubleClick();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();


        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        mainPage.continueAfterTrainSelect.click();
        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeDodatniPutnikDrugiPopust() {
        System.out.println("jednosmjernoPutovanjeDodatniPutnikDrugiPopust");


        MainPageAssert.assertMainPage();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");
        Date.setDateOutward(1);
        mainPage.increasePassengerCountSecondary.click();
        mainPage.discountStudentSecondary.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();


        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjeDodatniPutnikDrugiPopust() {
        System.out.println("povratnoPutovanjeDodatniPutnikDrugiPopust");


        MainPageAssert.assertMainPage();
        PovratnoPutovanje.odaberiPovratno();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");
        Date.setDateOutward(1);
        Date.setDateReturn(1);
        mainPage.increasePassengerCountSecondary.click();
        mainPage.discountUmirovljenikSecondary.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();


        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        mainPage.continueAfterTrainSelect.click();
        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeRezervacijaPrviRazred() {
        System.out.println("jednosmjernoPutovanjeRezervacijaPrviRazred");


        MainPageAssert.assertMainPage();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Split");
        Date.setDateOutward(1);
        mainPage.selectFirstClass.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        softAssert.assertEquals(MainPageAssert.assertSearch(parametriPretrage.polaznaStanica, parametriPretrage.odredisnaStanica),
                parametriPretrage.polaznaStanica + " → " + parametriPretrage.odredisnaStanica,
                "Relation is not matching");

        mainPage.firstOdaberiButton.click();
        //assert should come here

        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        mainPage.freeReservationSpot.click();
        mainPage.continueReservation.click();

        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjeRezervacijaPrviRazred() {
        System.out.println("povratnoPutovanjeRezervacijaPrviRazred");

        MainPageAssert.assertMainPage();
        PovratnoPutovanje.odaberiPovratno();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Split");
        mainPage.selectFirstClass.click();
        Date.setDateOutward(1);
        Date.setDateReturn(2);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        softAssert.assertEquals(MainPageAssert.assertSearch(parametriPretrage.polaznaStanica, parametriPretrage.odredisnaStanica),
                parametriPretrage.polaznaStanica + " → " + parametriPretrage.odredisnaStanica,
                "Relation is not matching");

        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        mainPage.freeReservationSpot.click();
        mainPage.freeReservationSpotReturn.click();
        mainPage.continueReservation.click();

        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeRezervacijaMjestaBicikla() {
        System.out.println("jednosmjernoPutovanjeRezervacijaMjestaBicikla");

        MainPageAssert.assertMainPage();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Split");
        mainPage.additionalOptionsOutward.click();//makes bicycle toggle button visible
        mainPage.toggleBicycleOutward.click();//activates bicycle toggle button
        Date.setDateOutward(1);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        softAssert.assertEquals(MainPageAssert.assertSearch(parametriPretrage.polaznaStanica, parametriPretrage.odredisnaStanica),
                parametriPretrage.polaznaStanica + " → " + parametriPretrage.odredisnaStanica,
                "Relation is not matching");
        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        mainPage.freeReservationSpot.click();
        mainPage.freeBicycleReservationSpot.click();
        mainPage.continueReservation.click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjeRezervacijaMjestaBicikla() {
        System.out.println("povratnoPutovanjeRezervacijaMjestaBicikla");


        MainPageAssert.assertMainPage();
        PovratnoPutovanje.odaberiPovratno();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Split");
        mainPage.additionalOptionsOutward.click();//makes bicycle outward toggle button visible
        mainPage.toggleBicycleOutward.click();//activates bicycle toggle button
        mainPage.additionalOptionsReturn.click();//makes bicycle return toggle button visible
        mainPage.toggleBicycleReturn.click();
        Date.setDateOutward(1);
        Date.setDateReturn(2);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        softAssert.assertEquals(MainPageAssert.assertSearch(parametriPretrage.polaznaStanica, parametriPretrage.odredisnaStanica),
                parametriPretrage.polaznaStanica + " → " + parametriPretrage.odredisnaStanica,
                "Relation is not matching");


        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here

        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        mainPage.freeReservationSpot.click();
        mainPage.freeBicycleReservationSpot.click();
        mainPage.freeReservationSpotReturn.click();
        mainPage.freeBicycleReservationSpotReturn.click();
        mainPage.continueReservation.click();
        //assert should come here

        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjePopustStudent() {
        System.out.println("jednosmjernoPutovanjePopustStudent");


        MainPageAssert.assertMainPage();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");
        Date.setDateOutward(1);
        mainPage.discountStudentPrimary.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();


        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjePopustStudent() {
        System.out.println("povratnoPutovanjePopustStudent");


        MainPageAssert.assertMainPage();
        PovratnoPutovanje.odaberiPovratno();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");
        Date.setDateOutward(1);
        Date.setDateReturn(1);
        mainPage.discountStudentPrimary.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();


        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        mainPage.continueAfterTrainSelect.click();
        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }


    @Test
    public void jednosmjernoPutovanjePopustMladi() {
        System.out.println("jednosmjernoPutovanjePopustMladi");


        MainPageAssert.assertMainPage();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");
        Date.setDateOutward(1);
        mainPage.discountMladiPrimary.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();


        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjePopustMladi() {
        System.out.println("povratnoPutovanjePopustMladi");


        MainPageAssert.assertMainPage();
        PovratnoPutovanje.odaberiPovratno();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");
        Date.setDateOutward(1);
        Date.setDateReturn(1);
        mainPage.discountMladiPrimary.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();


        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        mainPage.continueAfterTrainSelect.click();
        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjePopustUmirovljenik() {
        System.out.println("jednosmjernoPutovanjePopustUmirovljenik");


        MainPageAssert.assertMainPage();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");
        Date.setDateOutward(1);
        mainPage.discountUmirovljenikPrimary.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();


        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjePopustUmirovljenik() {
        System.out.println("povratnoPutovanjePopustUmirovljenik");


        MainPageAssert.assertMainPage();
        PovratnoPutovanje.odaberiPovratno();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");
        Date.setDateOutward(1);
        Date.setDateReturn(1);
        mainPage.discountUmirovljenikPrimary.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();


        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        mainPage.continueAfterTrainSelect.click();
        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeRezervacijaLezaj() {
        System.out.println("jednosmjernoPutovanjeRezervacijaLezaj");


        MainPageAssert.assertMainPage();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Osijek", "Zagreb Glavni kol.");
        Date.setDateOutward(1);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        softAssert.assertEquals(MainPageAssert.assertSearch(parametriPretrage.polaznaStanica, parametriPretrage.odredisnaStanica),
                parametriPretrage.polaznaStanica + " → " + parametriPretrage.odredisnaStanica,
                "Relation is not matching");
        //assert should come here

        mainPage.selectTrain580.click();
        //assert should come here

        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        mainPage.freeReservationCouchetteSpot.click();
        mainPage.continueReservation.click();

        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here


        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjeRezervacijaLezaj() {
        System.out.println("povratnoPutovanjeRezervacijaLezaj");


        MainPageAssert.assertMainPage();
        PovratnoPutovanje.odaberiPovratno();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Osijek", "Zagreb Glavni kol.");
        Date.setDateOutward(1);
        Date.setDateReturn(2);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        softAssert.assertEquals(MainPageAssert.assertSearch(parametriPretrage.polaznaStanica, parametriPretrage.odredisnaStanica),
                parametriPretrage.polaznaStanica + " → " + parametriPretrage.odredisnaStanica,
                "Relation is not matching");
        //assert should come here

        mainPage.selectTrain580.click();
        mainPage.selectTrain985.click();
        //assert should come here

        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        mainPage.freeReservationCouchetteSpot.click();
        mainPage.freeReservationCouchetteSpotReturn.click();
        mainPage.continueReservation.click();

        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeOpcionalnaRezervacija_BEZ() {
        System.out.println("jednosmjernoPutovanjeOpcionalnaRezervacija_BEZ");


        MainPageAssert.assertMainPage();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Vinkovci");
        Date.setDateOutward(1);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        softAssert.assertEquals(MainPageAssert.assertSearch(parametriPretrage.polaznaStanica, parametriPretrage.odredisnaStanica),
                parametriPretrage.polaznaStanica + " → " + parametriPretrage.odredisnaStanica,
                "Relation is not matching");
        //assert should come here

        mainPage.selectTrain545.click();
        //assert should come here

        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        mainPage.selectNoReservation.click();
        //assert should come here

        mainPage.continueReservation.click();
        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjeOpcionalnaRezervacija_BEZ() {
        System.out.println("povratnoPutovanjeOpcionalnaRezervacija_BEZ");


        MainPageAssert.assertMainPage();

        PovratnoPutovanje.odaberiPovratno();

        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Vinkovci");

        Date.setDateOutward(1);
        Date.setDateReturn(2);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        softAssert.assertEquals(MainPageAssert.assertSearch(parametriPretrage.polaznaStanica, parametriPretrage.odredisnaStanica),
                parametriPretrage.polaznaStanica + " → " + parametriPretrage.odredisnaStanica,
                "Relation is not matching");
        //assert should come here
        mainPage.selectTrain545.click();
        mainPage.selectTrain542.click();
        //assert should come here


        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        mainPage.selectNoReservation.click();
        mainPage.selectNoReservationReturn.click();
        mainPage.continueReservation.click();

        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeRegistriraniKorisnik() {
        System.out.println("jednosmjernoPutovanjeRegistriraniKorisnik");


        MainPageAssert.assertMainPage();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Sesvete");
        Date.setDateOutward(1);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();


        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        UserDataRegistration.fillInfo(environmentDataUAT.registeredUserMail, environmentDataUAT.registeredUserPass);
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeRezervacijaSjedecMjesta() {
        System.out.println("jednosmjernoPutovanjeRezervacijaSjedecMjesta");


        MainPageAssert.assertMainPage();
        ParametriPretrage parametriPretrage = new ParametriPretrage("Zagreb Glavni kol.", "Split");
        Date.setDateOutward(1);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        softAssert.assertEquals(MainPageAssert.assertSearch(parametriPretrage.polaznaStanica, parametriPretrage.odredisnaStanica),
                parametriPretrage.polaznaStanica + " → " + parametriPretrage.odredisnaStanica,
                "Relation is not matching");


        mainPage.selectTrain523.click();
        //assert should come here

        mainPage.continueAfterTrainSelect.click();
        //assert should come here

        mainPage.freeReservationSeat.click();
        mainPage.continueReservation.click();

        UserDataNoRegistration.fillInfo();
        //assert should come here

        ConditionsOfSaleScreen.acceptGeneralConditionsOfSale();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        softAssert.assertEquals(MainPageAssert.assertPurchase(), "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        MainPageAssert.downloadTicket();


        softAssert.assertAll();


    }
    //new tests come here

    @AfterTest
    public static void close() {
        WebDriver driver=new ChromeDriver();
        driver.close(); //closes the browser
        closeWindow();
        closeWebDriver();
    }
}
