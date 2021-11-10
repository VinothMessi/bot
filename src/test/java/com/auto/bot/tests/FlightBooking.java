package com.auto.bot.tests;

import com.auto.bot.BaseTest;
import com.auto.bot.appdetails.Flight;
import com.auto.bot.appdetails.Visa;
import com.auto.bot.flightpages.RegistrationForm;
import com.auto.bot.visapages.VisaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public
class FlightBooking extends BaseTest {
    @Autowired
    private
    RegistrationForm registrationForm;

    @Autowired
    private Flight flightApp;

    @BeforeMethod
    public
    void before() {
        browser.navigate().to(flightApp.getUrl());
    }

    @Test
    public
    void flightBooking() {
        registrationForm.hasLoaded();
        assertThat(registrationForm.heading()).isEqualTo(flightApp.getHeading());
        assertThat(registrationForm.subHeading()).isEqualTo(flightApp.getSubHeading());
        registrationForm.fill("Lionel", "Messi", "0123456789",
                "lionel.messi@gail.com", "village called Arroyo Seco", "Rosario", "Santa Fe",
                "S2000", "ARGENTINA", "lionel.messi",
                "welcome123");
        registrationForm.submit();
        registrationForm.acknowledgement();
    }
}