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
class CountryDetails extends BasePage {
    By fromCountry = By.id("input_46");
    By toCountry = By.id("input_47");

    @Override
    public
    boolean hasLoaded() {
        return canWeSee(fromCountry) && canWeClickOn(fromCountry) &&
                canWeSee(toCountry) && canWeClickOn(toCountry);
    }

    public
    void fill(String fCountry, String tCountry) {
        select("value", fCountry, fromCountry);
        select("value", tCountry, toCountry);
    }
}