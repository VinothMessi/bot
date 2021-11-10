package com.auto.bot.visapages;

import com.auto.bot.BasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public
class VisaForm extends BasePage {
    By visaForm = By.xpath("//ul[@class='form-section page-section']");
    By heading = By.id("header_1");
    By subHeading = By.id("subHeader_1");
    By submit = By.id("submitBtn");

    @Autowired
    private
    UserDetails userDetails;

    @Autowired
    private
    CountryDetails countryDetails;

    @Autowired
    private
    BirthDetails birthDetails;

    @Autowired
    private
    ContactDetails contactDetails;

    @Autowired
    private
    Confirmation confirmation;

    @Override
    public
    boolean hasLoaded() {
        return isPresent(visaForm);
    }

    public
    String heading() {
        return getTextFrom(heading);
    }

    public
    String subHeading() {
        return getTextFrom(subHeading);
    }

    public
    void fill(String fName, String mName, String lName, String fCountry, String tCountry,
              String bMonth, String bDay, String bYear,
              String eMail, String aCode, String pNumber, String message) {
        userDetails.hasLoaded();
        userDetails.fill(fName, mName, lName);
        countryDetails.hasLoaded();
        countryDetails.fill(fCountry, tCountry);
        birthDetails.hasLoaded();
        birthDetails.fill(bMonth, bDay, bYear);
        contactDetails.hasLoaded();
        contactDetails.fill(eMail, aCode, pNumber, message);
    }

    public
    void submit() {
        clickOn(submit);
    }

    public
    void acknowledgement() {
        confirmation.hasLoaded();
        System.out.println(confirmation.message());
    }
}