package com.auto.bot.visapages;

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
class ContactDetails extends BasePage {
    By email = By.id("input_6");
    By areaCode = By.id("input_27_area");
    By phoneNumber = By.id("input_27_phone");
    By comments = By.id("input_45");

    @Override
    public
    boolean hasLoaded() {
        return canWeSee(email) && canWeClickOn(email) &&
                canWeSee(areaCode) && canWeClickOn(areaCode) &&
                canWeSee(phoneNumber) && canWeClickOn(phoneNumber) &&
                canWeSee(comments) && canWeClickOn(comments);
    }

    public
    void fill(String eMail, String aCode, String pNumber, String message) {
        type(eMail, email);
        type(aCode, areaCode);
        type(pNumber, phoneNumber);
        type(message, comments);
    }
}