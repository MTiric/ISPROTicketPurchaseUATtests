package com.example.isproticketpurchaseuattests;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.jetbrains.com/
public class MainPage {
  public SelenideElement seeDeveloperToolsButton = $x("//*[@data-test-marker='Developer Tools']");
  public SelenideElement findYourToolsButton = $x("//*[@data-test='suggestion-action']");
  public SelenideElement toolsMenu = $x("//div[@data-test='main-menu-item' and @data-test-marker = 'Developer Tools']");
  public SelenideElement searchButton = $("[data-test='site-header-search-action']");
  public SelenideElement searchViewWrapper = $( "#searchViewWrapper");
  public SelenideElement firstOdaberiButton = $("#outwardJourneySelectDep");
  public SelenideElement lastOdaberiButton = $x("//div[@id='returnJourneyTableContainer']//div[@class='outerTable']//div[@class='item row'][last()]//button");

  public SelenideElement pretrazi = $("#submitButton");

  public SelenideElement increasePassengerCount = $x("//input[@id='Passenger1Count']/following-sibling::a[@class='ui-spinner-button ui-spinner-up ui-corner-tr ui-button ui-widget ui-state-default ui-button-text-only']");

  public SelenideElement decreasePassengerCount = $x("//input[@id='Passenger1Count']/following-sibling::a[@class='ui-spinner-button ui-spinner-down ui-corner-br ui-button ui-widget ui-state-default ui-button-text-only']");

  public SelenideElement increasePassengerCountSecondary = $x("//input[@id='Passenger2Count']/following-sibling::a[@class='ui-spinner-button ui-spinner-up ui-corner-tr ui-button ui-widget ui-state-default ui-button-text-only']");

  public SelenideElement decreasePassengerCountSecondary = $x("//input[@id='Passenger1Count']/following-sibling::a[@class='ui-spinner-button ui-spinner-down ui-corner-br ui-button ui-widget ui-state-default ui-button-text-only']");

  public SelenideElement discountStudentPrimary = $x("//select[@id='Benefit1Id']/option[text()='Student']");

  public SelenideElement discountMladiPrimary = $x("//select[@id='Benefit1Id']/option[text()='Mladi do 26 godina']");

  public SelenideElement discountUmirovljenikPrimary = $x("//select[@id='Benefit1Id']/option[text()='Umirovljenik ili starija osoba']");

  public SelenideElement discountStudentSecondary = $x("//select[@id='Benefit2Id']/option[text()='Student']");

  public SelenideElement discountUmirovljenikSecondary = $x("//select[@id='Benefit2Id']/option[text()='Umirovljenik ili starija osoba']");

  public SelenideElement selectFirstClass = $x("//select[@id='Class']/option[text()='1. razred']");

  public SelenideElement freeReservationSpot = $x("//div[contains(@class, 'free')]");

  public SelenideElement freeReservationCouchetteSpot = $x("//div[@class='seatDiv Lining free']");

  public SelenideElement freeReservationSpotReturn = $x("//div[@class='panel panel-default'][last()]//div[@class='seatDiv seat free']");

  public SelenideElement freeReservationSeat = $x("//div[@class='seatDiv seat free']");
  public SelenideElement freeReservationCouchetteSpotReturn = $x("//div[@class='panel panel-default'][last()]//div[@class='seatDiv Lining free']");
  public SelenideElement continueReservation = $x("//a[@id='reservationSubmitBtn']");

  public SelenideElement freeBicycleReservationSpot = $x("//div[@class='seatDiv bicycle free']");

  public SelenideElement additionalOptionsOutward = $x("//div[@class='additional-ticket-options']//div[@class='departure-options']");

  public SelenideElement additionalOptionsReturn = $x("//div[@class='additional-ticket-options']//div[@class='return-options']");

  public SelenideElement toggleBicycleOutward = $x("//div[@title='Samo vlakovi s mogućnosti prijevoza bicikala']//label");

  public SelenideElement toggleBicycleReturn = $x("//div[@class='additional-ticket-options']//div[@class='return-options']//label");

  public SelenideElement freeBicycleReservationSpotReturn = $x("//div[@class='panel panel-default'][last()]//div[@class='seatDiv bicycle free']");

  public SelenideElement selectTrain580 = $x("//a[@detailsid='580']/parent::div/parent::div//button[@id='outwardJourneySelectDep']");

  public SelenideElement selectTrain985 = $x("//a[@detailsid='985']/parent::div/parent::div//button[@id='outwardJourneySelectDep']");

  public SelenideElement selectTrain545 = $x("//a[@detailsid='545']/parent::div/parent::div//button[@id='outwardJourneySelectDep']");

  public SelenideElement selectTrain542 = $x("//a[@detailsid='542']/parent::div/parent::div//button[@id='outwardJourneySelectDep']");

  public SelenideElement selectTrain523 = $x("//a[@detailsid='523']/parent::div/parent::div//button[@id='outwardJourneySelectDep']");
  public SelenideElement selectNoReservation = $x("//input[@class='checkboxNoReservations']");

  public SelenideElement selectNoReservationReturn = $x("//div[@class='panel panel-default'][last()]//input[@class='checkboxNoReservations']");

  public SelenideElement continueAfterTrainSelect = $("#ContinueBtn");
}
