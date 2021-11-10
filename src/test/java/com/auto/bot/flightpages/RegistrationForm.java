package com.auto.bot.flightpages;

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
class RegistrationForm extends BasePage {
    By registrationForm = By.id("cid_37");
    By heading = By.id("header_14");
    By subHeading = By.xpath("(//h1)[2]");
    By submit = By.id("register-btn");

    @Autowired
    private
    ContactInformation contact;

    @Autowired
    private
    MailingInformation mailing;

    @Autowired
    private
    UserInformation user;

    @Autowired
    private
    UserConfirmation confirmation;

    @Override
    public
    boolean hasLoaded() {
        return isPresent(registrationForm);
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
    void fill(String fName, String lName, String pHone, String eMail,
              String address, String city, String state, String code, String country,
              String userName, String passWord) {
        contact.hasLoaded();
        contact.fill(fName, lName, pHone, eMail);
        mailing.hasLoaded();
        mailing.fill(address, city, state, code, country);
        user.hasLoaded();
        user.fill(userName, passWord);
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