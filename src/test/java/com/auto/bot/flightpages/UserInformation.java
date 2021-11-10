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
class UserInformation extends BasePage {
    By userName = By.name("email");
    By password = By.name("password");
    By confirmPassword = By.name("confirmPassword");

    @Override
    public
    boolean hasLoaded() {
        return canWeSee(userName) && canWeClickOn(userName) &&
                canWeSee(password) && canWeClickOn(password) &&
                canWeSee(confirmPassword) && canWeClickOn(confirmPassword);
    }

    public
    void fill(String uName, String passWord) {
        type(uName, userName);
        type(passWord, password);
        type(passWord, confirmPassword);
    }
}