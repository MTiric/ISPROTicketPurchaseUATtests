package com.example.isproticketpurchaseuattests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;



public class MainPageTest {
    MainPage mainPage = new MainPage();


    String urlMain = "https://prodaja-test.hzpp.hr/";

    SoftAssert softAssert = new SoftAssert();

    @BeforeSuite    public static void setUpAll() {
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

    @Test(description = "Jednosmjerno putovanje normalna karta")
    public void jednosmjernoPutovanjeNormalnaKartaTest() {
        System.out.println("Jednosmjerno putovanje normalna karta");

        $("#searchViewWrapper").shouldBe(visible);
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        $("#ContinueBtn").click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here

        PayWayInfo.fillInfo();
        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjeNormalnaKarta() {
        System.out.println("povratnoPutovanjeNormalnaKarta");


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(1);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        $("#ContinueBtn").click();
        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }
    @Test
    public void jednosmjernoPutovanjeSviVlakovi() {
        System.out.println("povratnoPutovanjeNormalnaKarta");

        $("#searchViewWrapper").shouldBe(visible);
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");

        $x("//input[@id='DirectTrains'][@value='false']").click(); //clicks on "All trains" radio button(svi vlakovi)
        System.out.println(DifferentDateTime.returnFuture(1));

        SetDateOutward.setDate(1);
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here

        $("#outwardJourneySelectDep").click();
        //assert should come here

        $("#ContinueBtn").click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here

        PayWayInfo.fillInfo();
        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjeSviVlakovi() {
        System.out.println("povratnoPutovanjeSviVlakovi");

        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        $x("//input[@id='DirectTrains'][@value='false']").click(); //clicks on "All trains" radio button(svi vlakovi)
        System.out.println(DifferentDateTime.returnFuture(1));

        SetDateOutward.setDate(1);
        SetDateReturn.setDate(1);
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        $("#ContinueBtn").click();
        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!", "The purchased screen title is not matching");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }
    @Test
    public void jednosmjernoPutovanjeTriPutnika() {
        System.out.println("jednosmjernoPutovanjeTriPutnika");

        $("#searchViewWrapper").shouldBe(visible);
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        mainPage.increasePassengerCount.doubleClick();
        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        $("#ContinueBtn").click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjeTriPutnika() {
        System.out.println("povratnoPutovanjeTriPutnika");

        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(1);
        mainPage.increasePassengerCount.doubleClick();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        $("#ContinueBtn").click();
        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeSestPutnika() {
        System.out.println("jednosmjernoPutovanjeSestPutnika");

        $("#searchViewWrapper").shouldBe(visible);
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        mainPage.increasePassengerCount.doubleClick();
        mainPage.decreasePassengerCount.click();
        mainPage.increasePassengerCount.doubleClick();
        mainPage.decreasePassengerCount.click();
        mainPage.increasePassengerCount.doubleClick();
        mainPage.decreasePassengerCount.click();
        mainPage.increasePassengerCount.doubleClick();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        $("#ContinueBtn").click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }
    @Test
    public void povratnoPutovanjeSestPutnika() {
        System.out.println("povratnoPutovanjeSestPutnika");


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(1);
        mainPage.increasePassengerCount.doubleClick();
        mainPage.decreasePassengerCount.click();
        mainPage.increasePassengerCount.doubleClick();
        mainPage.decreasePassengerCount.click();
        mainPage.increasePassengerCount.doubleClick();
        mainPage.decreasePassengerCount.click();
        mainPage.increasePassengerCount.doubleClick();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        $("#ContinueBtn").click();
        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeDodatniPutnikDrugiPopust() {
        System.out.println("jednosmjernoPutovanjeDodatniPutnikDrugiPopust");


        $("#searchViewWrapper").shouldBe(visible);
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        mainPage.increasePassengerCountSecondary.click();
        mainPage.discountStudentSecondary.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        $("#ContinueBtn").click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }
    @Test
    public void povratnoPutovanjeDodatniPutnikDrugiPopust() {
        System.out.println("povratnoPutovanjeDodatniPutnikDrugiPopust");


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(1);
        mainPage.increasePassengerCountSecondary.click();
        mainPage.discountUmirovljenikSecondary.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        $("#ContinueBtn").click();
        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeRezervacijaPrviRazred() {
        System.out.println("jednosmjernoPutovanjeRezervacijaPrviRazred");


        $("#searchViewWrapper").shouldBe(visible);
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Split");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        mainPage.selectFirstClass.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Split']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Split", "Relation is not matching" );
        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        $("#ContinueBtn").click();
        //assert should come here

        mainPage.freeReservationSpot.click();
        $x("//a[@id='reservationSubmitBtn']").click();

        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjeRezervacijaPrviRazred() {
        System.out.println("povratnoPutovanjeRezervacijaPrviRazred");

        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Split");
        mainPage.selectFirstClass.click();
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(2);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Split']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Split", "Relation is not matching" );
        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        $("#ContinueBtn").click();
        //assert should come here

        mainPage.freeReservationSpot.click();
        mainPage.freeReservationSpotReturn.click();
        mainPage.continueReservation.click();

        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeRezervacijaMjestaBicikla() {
        System.out.println("jednosmjernoPutovanjeRezervacijaMjestaBicikla");

        $("#searchViewWrapper").shouldBe(visible);
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Split");
        mainPage.additionalOptionsOutward.click();//makes bicycle toggle button visible
        mainPage.toggleBicycleOutward.click();//activates bicycle toggle button
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Split']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Split", "Relation is not matching" );
        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        $("#ContinueBtn").click();
        //assert should come here

        mainPage.freeReservationSpot.click();
        mainPage.freeBicycleReservationSpot.click();
        mainPage.continueReservation.click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjeRezervacijaMjestaBicikla() {
        System.out.println("povratnoPutovanjeRezervacijaMjestaBicikla");


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Split");
        mainPage.additionalOptionsOutward.click();//makes bicycle outward toggle button visible
        mainPage.toggleBicycleOutward.click();//activates bicycle toggle button
        mainPage.additionalOptionsReturn.click();//makes bicycle return toggle button visible
        mainPage.toggleBicycleReturn.click();
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(2);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Split']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Split", "Relation is not matching" );
        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here

        $("#ContinueBtn").click();
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

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjePopustStudent() {
        System.out.println("jednosmjernoPutovanjePopustStudent");


        $("#searchViewWrapper").shouldBe(visible);
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        mainPage.discountStudentPrimary.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        $("#ContinueBtn").click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjePopustStudent() {
        System.out.println("povratnoPutovanjePopustStudent");


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(1);
        mainPage.discountStudentPrimary.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        $("#ContinueBtn").click();
        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }


    @Test
    public void jednosmjernoPutovanjePopustMladi() {
        System.out.println("jednosmjernoPutovanjePopustMladi");


        $("#searchViewWrapper").shouldBe(visible);
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        mainPage.discountMladiPrimary.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        $("#ContinueBtn").click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjePopustMladi() {
        System.out.println("povratnoPutovanjePopustMladi");


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(1);
        mainPage.discountMladiPrimary.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        $("#ContinueBtn").click();
        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjePopustUmirovljenik() {
        System.out.println("jednosmjernoPutovanjePopustUmirovljenik");


        $("#searchViewWrapper").shouldBe(visible);
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        mainPage.discountUmirovljenikPrimary.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        $("#ContinueBtn").click();
        //assert should come here

        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjePopustUmirovljenik() {
        System.out.println("povratnoPutovanjePopustUmirovljenik");


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(1);
        mainPage.discountUmirovljenikPrimary.click();

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here
        mainPage.firstOdaberiButton.click();
        mainPage.lastOdaberiButton.click();
        //assert should come here


        $("#ContinueBtn").click();
        //assert should come here
        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeRezervacijaLezaj() {
        System.out.println("jednosmjernoPutovanjeRezervacijaLezaj");


        $("#searchViewWrapper").shouldBe(visible);
        ParametriPretrage.fillData("Osijek", "Zagreb Glavni kol.");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Osijek → Zagreb Glavni kol.']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Osijek → Zagreb Glavni kol.", "Relation is not matching" );
        //assert should come here

        mainPage.selectTrain580.click();
        //assert should come here

        $("#ContinueBtn").click();
        //assert should come here

        mainPage.freeReservationCouchetteSpot.click();
        mainPage.continueReservation.click();

        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjeRezervacijaLezaj() {
        System.out.println("povratnoPutovanjeRezervacijaLezaj");


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Osijek", "Zagreb Glavni kol.");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(2);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Osijek → Zagreb Glavni kol.']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Osijek → Zagreb Glavni kol.", "Relation is not matching" );
        //assert should come here

        mainPage.selectTrain580.click();
        mainPage.selectTrain985.click();
        //assert should come here

        $("#ContinueBtn").click();
        //assert should come here

        mainPage.freeReservationCouchetteSpot.click();
        mainPage.freeReservationCouchetteSpotReturn.click();
        mainPage.continueReservation.click();

        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeOpcionalnaRezervacija_BEZ() {
        System.out.println("jednosmjernoPutovanjeOpcionalnaRezervacija_BEZ");


        $("#searchViewWrapper").shouldBe(visible);
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Vinkovci");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Vinkovci']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Vinkovci", "Relation is not matching" );
        //assert should come here

        mainPage.selectTrain545.click();
        //assert should come here

        $("#ContinueBtn").click();
        //assert should come here

        mainPage.selectNoReservation.click();
        //assert should come here

        mainPage.continueReservation.click();
        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void povratnoPutovanjeOpcionalnaRezervacija_BEZ() {
        System.out.println("povratnoPutovanjeOpcionalnaRezervacija_BEZ");


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Vinkovci");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(2);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Vinkovci']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Vinkovci", "Relation is not matching" );
        //assert should come here
        mainPage.selectTrain545.click();
        mainPage.selectTrain542.click();
        //assert should come here


        $("#ContinueBtn").click();
        //assert should come here

        mainPage.selectNoReservation.click();
        mainPage.selectNoReservationReturn.click();
        mainPage.continueReservation.click();

        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here


        PayWayInfo.fillInfo();
        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }
    @Test
    public void jednosmjernoPutovanjeRegistriraniKorisnik() {
        System.out.println("jednosmjernoPutovanjeRegistriraniKorisnik");


        $("#searchViewWrapper").shouldBe(visible);
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Sesvete']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Sesvete", "Relation is not matching" );
        //assert should come here

        mainPage.firstOdaberiButton.click();
        //assert should come here

        $("#ContinueBtn").click();
        //assert should come here

        UserDataRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }

    @Test
    public void jednosmjernoPutovanjeRezervacijaSjedecMjesta() {
        System.out.println("jednosmjernoPutovanjeRezervacijaSjedecMjesta");


        $("#searchViewWrapper").shouldBe(visible);
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Split");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);

        //!!!!!^^^^^^^^^!!!!!all the search parameters have to go before this point!!!!!^^^^^^^^^!!!!!
        mainPage.pretrazi.click();

        SelenideElement searchRelation = $x("//h4[text()='Zagreb Glavni kol. → Split']");
        String searchRelationActualResult = searchRelation.getText();
        System.out.println(searchRelationActualResult);
        softAssert.assertEquals(searchRelationActualResult, "Zagreb Glavni kol. → Split", "Relation is not matching" );
        //assert should come here

        mainPage.selectTrain523.click();
        //assert should come here

        $("#ContinueBtn").click();
        //assert should come here

        mainPage.freeReservationSeat.click();
        mainPage.continueReservation.click();

        UserDataNoRegistration.fillInfo();
        //assert should come here

        $("#GeneralConditionsOfSale").click();
        $("#SubmitForm").click();
        //assert should come here

        PayWayInfo.fillInfo();

        //assert should come here

        SelenideElement titleConfirmation = $x("//div[@class=\"title_confirmation\"]");
        String titleConfirmationText = titleConfirmation.getText();
        System.out.println(titleConfirmationText);
        softAssert.assertEquals(titleConfirmationText, "Uspješno ste dovršili kupnju. Hvala Vam i sretan put!");

        $x("//input[@id='pdfBtn']").click();


        sleep(5000);
        softAssert.assertAll();


    }
    //new tests come here

}
