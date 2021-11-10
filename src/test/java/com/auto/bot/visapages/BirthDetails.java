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
class BirthDetails extends BasePage {
    By month = By.id("input_24_month");
    By day = By.id("input_24_day");
    By year = By.id("input_24_year");

    @Override
    public
    boolean hasLoaded() {
        return canWeSee(month) && canWeClickOn(month) &&
                canWeSee(day) && canWeClickOn(day) &&
                canWeSee(year) && canWeClickOn(year);
    }

    public
    void fill(String bMonth, String bDay, String bYear) {
        select("value", bMonth, month);
        select("value", bDay, day);
        select("value", bYear, year);
    }
}