package com.example.isproticketpurchaseuattests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;



public class MainPageTest {
    MainPage mainPage = new MainPage();
    String urlMain = "https://prodaja-test.hzpp.hr/";



    @BeforeAll        public static void setUpAll() {
        Configuration.browserSize = "1280x800";
            SelenideLogger.addListener("allure", new AllureSelenide());
        }

    @BeforeEach        public void setUp() {
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");

        open(urlMain);


    }

    @Test
    public void jednosmjernoPutovanjeNormalnaKarta() {
        SoftAssert softAssert = new SoftAssert();


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
        SoftAssert softAssert = new SoftAssert();


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(2);

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
        SoftAssert softAssert = new SoftAssert();


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
        SoftAssert softAssert = new SoftAssert();


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        $x("//input[@id='DirectTrains'][@value='false']").click(); //clicks on "All trains" radio button(svi vlakovi)
        System.out.println(DifferentDateTime.returnFuture(1));

        SetDateOutward.setDate(1);
        SetDateReturn.setDate(2);
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
        SoftAssert softAssert = new SoftAssert();


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
        SoftAssert softAssert = new SoftAssert();


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(2);
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
        SoftAssert softAssert = new SoftAssert();


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
        SoftAssert softAssert = new SoftAssert();


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(2);
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
        SoftAssert softAssert = new SoftAssert();


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
        SoftAssert softAssert = new SoftAssert();


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(2);
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
        SoftAssert softAssert = new SoftAssert();


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
        SoftAssert softAssert = new SoftAssert();


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
        SoftAssert softAssert = new SoftAssert();


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
        SoftAssert softAssert = new SoftAssert();


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
        SoftAssert softAssert = new SoftAssert();


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
        SoftAssert softAssert = new SoftAssert();


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(2);
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
        SoftAssert softAssert = new SoftAssert();


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
        SoftAssert softAssert = new SoftAssert();


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(2);
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
        SoftAssert softAssert = new SoftAssert();


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
        SoftAssert softAssert = new SoftAssert();


        $("#searchViewWrapper").shouldBe(visible);
        $("#returnJourneyRadio").click();
        ParametriPretrage.fillData("Zagreb Glavni kol.", "Sesvete");
        System.out.println(DifferentDateTime.returnFuture(1));
        SetDateOutward.setDate(1);
        SetDateReturn.setDate(2);
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
        SoftAssert softAssert = new SoftAssert();


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
        SoftAssert softAssert = new SoftAssert();


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
    //new tests come here

}
