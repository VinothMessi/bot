package com.auto.bot.flightpages;

import com.auto.bot.BasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public
class ContactInformation extends BasePage {
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By phone = By.name("phone");
    By email = By.name("userName");

    @Override
    public
    boolean hasLoaded() {
        return canWeSee(firstName) && canWeClickOn(firstName) &&
                canWeSee(lastName) && canWeClickOn(lastName) &&
                canWeSee(phone) && canWeClickOn(phone) &&
                canWeSee(email) && canWeClickOn(email);
    }

    public
    void fill(String fName, String lName, String pHone, String eMail) {
        type(fName, firstName);
        type(lName, lastName);
        type(pHone, phone);
        type(eMail, email);
    }
}