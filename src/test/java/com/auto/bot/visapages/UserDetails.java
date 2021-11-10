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
class UserDetails extends BasePage {
    By firstName = By.id("first_4");
    By middleName = By.id("middle_4");
    By lastName = By.id("last_4");

    @Override
    public
    boolean hasLoaded() {
        return canWeSee(firstName) && canWeClickOn(firstName) &&
                canWeSee(middleName) && canWeClickOn(middleName) &&
                canWeSee(lastName) && canWeClickOn(lastName);
    }

    public
    void fill(String fName, String mName, String lName) {
        type(fName, firstName);
        type(mName, middleName);
        type(lName, lastName);
    }
}