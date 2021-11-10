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
class MailingInformation extends BasePage {
    By address = By.name("address1");
    By city = By.name("city");
    By state = By.name("state");
    By postalCode = By.name("postalCode");
    By country = By.name("country");

    @Override
    public
    boolean hasLoaded() {
        return canWeSee(address) && canWeClickOn(address) &&
                canWeSee(city) && canWeClickOn(city) &&
                canWeSee(state) && canWeClickOn(state) &&
                canWeSee(postalCode) && canWeClickOn(postalCode) &&
                canWeSee(country) && canWeClickOn(country);
    }

    public
    void fill(String uAddress, String uCity, String uState, String uCode, String uCountry) {
        type(uAddress, address);
        type(uCity, city);
        type(uState, state);
        type(uCode, postalCode);
        select("value", uCountry, country);
    }
}