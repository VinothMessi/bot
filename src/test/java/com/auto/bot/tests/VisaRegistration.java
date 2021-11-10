package com.auto.bot.tests;

import com.auto.bot.BaseTest;
import com.auto.bot.appdetails.Visa;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public
class VisaRegistration extends BaseTest {
    @Autowired
    private Visa visaApp;

    @BeforeMethod
    public
    void before() {
        browser.navigate().to(visaApp.getUrl());
    }

    @Test
    public
    void visaRegistration() {
        visaForm.hasLoaded();
        assertThat(visaForm.heading()).isEqualTo(visaApp.getHeading());
        assertThat(visaForm.subHeading()).isEqualTo(visaApp.getSubHeading());
        visaForm.fill("Lionel", "Andrés", "Messi",
                "Argentina", "France", "JUNE", "24", "1987",
                "lionel.messi@gail.com", "+54", "0123456789", "Form completed successfully!!!");
        visaForm.submit();
        visaForm.acknowledgement();
    }
}